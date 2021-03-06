package com.github.qingmei2.sample.ui.main.repos

import com.github.qingmei2.mvi.base.action.IAction

sealed class ReposAction : IAction {

    data class QueryReposAction(val sortType: String) : ReposAction()

    data class ScrollStateChangedAction(val state: Int) : ReposAction()

    object ScrollToTopAction : ReposAction()
}