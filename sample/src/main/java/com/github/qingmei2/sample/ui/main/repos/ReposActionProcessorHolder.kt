package com.github.qingmei2.sample.ui.main.repos

import arrow.core.left
import com.github.qingmei2.mvi.ext.paging.IntPageKeyedData
import com.github.qingmei2.mvi.ext.paging.IntPageKeyedDataSource
import com.github.qingmei2.mvi.ext.paging.Paging
import com.github.qingmei2.mvi.ext.reactivex.flatMapErrorActionObservable
import com.github.qingmei2.sample.entity.Errors
import com.github.qingmei2.sample.entity.Repo
import com.github.qingmei2.sample.http.scheduler.SchedulerProvider
import com.github.qingmei2.sample.manager.UserManager
import com.github.qingmei2.sample.ui.main.common.scrollStateProcessor
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.subjects.PublishSubject

class ReposActionProcessorHolder(
    private val repository: ReposDataSource,
    private val schedulerProvider: SchedulerProvider
) {
    private val reposLoadingEventSubject: PublishSubject<ReposResult> =
        PublishSubject.create()

    private val initialActionTransformer =
        ObservableTransformer<ReposAction.QueryReposAction, ReposResult> { action ->
            action.flatMap<ReposResult> {
                Paging.buildPageKeyedDataSource(receivedEventDataSource(it.sortType))
                    .map(ReposResult::QueryReposResult)
                    .toObservable()
            }
        }

    private val scrollStateChangeTransformer =
        ObservableTransformer<ReposAction.ScrollStateChangedAction, ReposResult> { action ->
            action
                .map { it.state }
                .compose(scrollStateProcessor)
                .map(ReposResult::FloatActionButtonVisibleResult)
        }

    private fun receivedEventDataSource(sortType: String): IntPageKeyedDataSource<Repo> = IntPageKeyedDataSource(
        loadInitial = {
            repository
                .queryRepos(UserManager.INSTANCE.login, pageIndex = 1, perPage = 15, sort = sortType)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .onErrorReturn { Errors.ErrorWrapper(it).left() }
                .doOnSubscribe {
                    reposLoadingEventSubject.onNext(
                        ReposResult.ReposPageResult.InFlight(true)
                    )
                }
                .flatMap { either ->
                    either.fold({
                        reposLoadingEventSubject.onNext(
                            ReposResult.ReposPageResult.Failure(true, it)
                        )
                        Flowable.empty<IntPageKeyedData<Repo>>()
                    }, { datas ->
                        reposLoadingEventSubject.onNext(
                            ReposResult.ReposPageResult.Success(true)
                        )
                        Flowable.just(
                            IntPageKeyedData.build(
                                data = datas,
                                pageIndex = 1,
                                hasAdjacentPageKey = datas.isNotEmpty()
                            )
                        )
                    })
                }
        },
        loadAfter = { param ->
            repository
                .queryRepos(UserManager.INSTANCE.login, param.key, perPage = 15, sort = sortType)
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .onErrorReturn { Errors.ErrorWrapper(it).left() }
                .doOnSubscribe {
                    reposLoadingEventSubject.onNext(
                        ReposResult.ReposPageResult.InFlight(false)
                    )
                }
                .flatMap { either ->
                    either.fold({
                        reposLoadingEventSubject.onNext(
                            ReposResult.ReposPageResult.Failure(false, it)
                        )
                        Flowable.empty<IntPageKeyedData<Repo>>()
                    }, { datas ->
                        reposLoadingEventSubject.onNext(
                            ReposResult.ReposPageResult.Success(false)
                        )
                        Flowable.just(
                            IntPageKeyedData.build(
                                data = datas,
                                pageIndex = param.key,
                                hasAdjacentPageKey = datas.isNotEmpty()
                            )
                        )
                    })
                }
        }
    )

    val actionProcessor: ObservableTransformer<ReposAction, ReposResult> =
        ObservableTransformer { actions ->
            actions.publish { shared ->
                Observable.mergeArray(
                    shared.ofType(ReposAction.QueryReposAction::class.java).compose(initialActionTransformer),
                    shared.ofType(ReposAction.ScrollToTopAction::class.java).map { ReposResult.ScrollToTopResult },
                    shared.ofType(ReposAction.ScrollStateChangedAction::class.java).compose(scrollStateChangeTransformer),
                    reposLoadingEventSubject,
                    shared.filter { o ->
                        o !is ReposAction.QueryReposAction
                                && o !is ReposAction.ScrollToTopAction
                                && o !is ReposAction.ScrollStateChangedAction
                    }.flatMapErrorActionObservable()
                )
            }
        }
}