# MVI-Rhine

#### [English Documentation](https://github.com/qingmei2/MVI-Rhine) | 中文文档

## 概述

这个 **Github客户端** 的Android项目是基于 **MVI** (Model-View-Intent) 模式进行开发的，项目整体 **业务逻辑** 和 **UI的交互逻辑** 全部交由 **RxJava2** 进行串联。

**MVI** 架构旨在使用  **响应式** 和 **函数式编程** （Reactive && Functional Programming）， 这个架构的两个主要组件，`View`和`ViewModel`可以看作是函数，两者间通过`RxJava`相互输入和输出：

![](https://github.com/qingmei2/MVI-Rhine/blob/master/screenshots/mvi_detail.png)

## 屏幕截图

<div align:left;display:inline;>
<img width="200" height="360" src="https://github.com/qingmei2/MVI-Rhine/blob/master/screenshots/login.png"/>
<img width="200" height="360" src="https://github.com/qingmei2/MVI-Rhine/blob/master/screenshots/home.png"/>
<img width="200" height="360" src="https://github.com/qingmei2/MVI-Rhine/blob/master/screenshots/repos.png"/>
<img width="200" height="360" src="https://github.com/qingmei2/MVI-Rhine/blob/master/screenshots/me.png"/>
</div>


## 三方组件

### Android 官方架构组件 Jetpack

* [Lifecycle: Create a UI that automatically responds to lifecycle events.](https://developer.android.com/topic/libraries/architecture/lifecycle)

* [ViewModel: Store UI-related data that isn't destroyed on app rotations. Easily schedule asynchronous tasks for optimal execution.](https://developer.android.com/topic/libraries/architecture/viewmodel)

* [Room: Access your app's SQLite database with in-app objects and compile-time checks.](https://developer.android.com/topic/libraries/architecture/room)

* [Navigation: Handle everything needed for in-app navigation.](https://developer.android.com/topic/libraries/architecture/navigation/)

* [Paging: Makes it easier for you to load data gradually and gracefully within your app's RecyclerView.](https://developer.android.com/topic/libraries/architecture/paging/)

### 网络请求

* [Retrofit2: Type-safe HTTP client for Android and Java by Square, Inc.](https://github.com/square/retrofit)

* [OkHttp: An HTTP+HTTP/2 client for Android and Java applications.](https://github.com/square/okhttp)

### 依赖注入

* [Kodein-DI: Painless Kotlin Dependency Injection](https://github.com/Kodein-Framework/Kodein-DI)

### 响应式库

* [RxKotlin: RxJava bindings for Kotlin](https://github.com/ReactiveX/RxKotlin)

* [RxJava2: A library for composing asynchronous and event-based programs using observable sequences for the Java VM](https://github.com/ReactiveX/RxJava)

* [RxAndroid: RxJava bindings for Android](https://github.com/ReactiveX/RxAndroid)

* [RxBinding: RxJava binding APIs for Android's UI widgets.](https://github.com/JakeWharton/RxBinding)

* [AutoDispose: Automatic binding+disposal of RxJava 2 streams.](https://github.com/uber/AutoDispose)

### 函数式库

* [Arrow: Functional companion to Kotlin's Standard Library.](https://arrow-kt.io/)

### 其它

* [Glide: An image loading and caching library for Android focused on smooth scrolling](https://github.com/bumptech/glide)

* [Timber: A logger with a small, extensible API which provides utility on top of Android's normal Log class.](https://github.com/JakeWharton/timber)

## 如何入手学习这个项目？

如何使用`Android Jetpack`？

>* [Android官方架构组件Lifecycle：生命周期组件详解&原理分析](https://juejin.im/post/5c53beaf51882562e27e5ad9)
>* [Android官方架构组件ViewModel:从前世今生到追本溯源](https://juejin.im/post/5c047fd3e51d45666017ff86)
>* [Android官方架构组件Paging：分页库的设计美学](https://juejin.im/post/5c53ad9e6fb9a049eb3c5cfd)
>* [Android官方架构组件Navigation：大巧不工的Fragment管理框架](https://juejin.im/post/5c53be3951882562d27416c6)

如何使用`Kodein`进行依赖注入？

> * [ 告别Dagger2，在Kotlin项目中使用Kodein进行依赖注入 ](https://www.jianshu.com/p/b0da805f7534)
> * [【译】Android开发从Dagger2迁移至Kodein的感受  ](https://www.jianshu.com/p/e5eef49570b9)

如何进阶学习`RxJava`？

> * [ 理解RxJava（一）：基本流程源码分析 ](https://www.jianshu.com/p/7fce2955f2db)
> * [ 理解RxJava（二）：操作符流程原理分析 ](https://www.jianshu.com/p/0a28428e734d)
> * [ 理解RxJava（三）：线程调度原理分析 ](https://www.jianshu.com/p/9e3930fbcb26)
> * [ 理解RxJava（四）Subject用法及原理分析 ](https://www.jianshu.com/p/d7efc29ec9d3)

> * [ 解决RxJava内存泄漏（前篇）：RxLifecycle详解及原理分析 ](https://www.jianshu.com/p/8311410de676)
> * [ 解决RxJava内存泄漏（后篇）：Android架构中添加AutoDispose解决RxJava内存泄漏 ](https://www.jianshu.com/p/8490d9383ba5)

如何理解 **MVI** 与 **状态管理** ：

> * [[译]使用MVI打造响应式APP(一):Model层到底代表什么](https://github.com/qingmei2/android-programming-profile/blob/master/src/Android-MVI/%5B%E8%AF%91%5D%E4%BD%BF%E7%94%A8MVI%E6%89%93%E9%80%A0%E5%93%8D%E5%BA%94%E5%BC%8FAPP%5B%E4%B8%80%5D%3AModel%E5%B1%82%E5%88%B0%E5%BA%95%E4%BB%A3%E8%A1%A8%E4%BB%80%E4%B9%88.md)
> * [[译]使用MVI打造响应式APP[二]:View层和Intent层](https://github.com/qingmei2/android-programming-profile/blob/master/src/Android-MVI/%5B%E8%AF%91%5D%E4%BD%BF%E7%94%A8MVI%E6%89%93%E9%80%A0%E5%93%8D%E5%BA%94%E5%BC%8FAPP%5B%E4%BA%8C%5D%3AView%E5%B1%82%E5%92%8CIntent%E5%B1%82.md)
> * [[译]使用MVI打造响应式APP[三]:StateReducer](https://github.com/qingmei2/android-programming-profile/blob/master/src/Android-MVI/%5B%E8%AF%91%5D%E4%BD%BF%E7%94%A8MVI%E6%89%93%E9%80%A0%E5%93%8D%E5%BA%94%E5%BC%8FAPP%5B%E4%B8%89%5D%3AStateReducer.md)
> * [[译]使用MVI打造响应式APP[四]:IndependentUIComponents](https://github.com/qingmei2/android-programming-profile/blob/master/src/Android-MVI/%5B%E8%AF%91%5D%E4%BD%BF%E7%94%A8MVI%E6%89%93%E9%80%A0%E5%93%8D%E5%BA%94%E5%BC%8FAPP%5B%E5%9B%9B%5D%3AIndependentUIComponents.md)
> * [[译]使用MVI打造响应式APP[五]:DebuggingWithEase](https://github.com/qingmei2/android-programming-profile/blob/master/src/Android-MVI/%5B%E8%AF%91%5D%E4%BD%BF%E7%94%A8MVI%E6%89%93%E9%80%A0%E5%93%8D%E5%BA%94%E5%BC%8FAPP%5B%E4%BA%94%5D%3ADebuggingWithEase.md)
> * [[译]使用MVI打造响应式APP[六]:RestoringState](https://github.com/qingmei2/android-programming-profile/blob/master/src/Android-MVI/%5B%E8%AF%91%5D%E4%BD%BF%E7%94%A8MVI%E6%89%93%E9%80%A0%E5%93%8D%E5%BA%94%E5%BC%8FAPP%5B%E5%85%AD%5D%3ARestoringState.md)
> * [[译]使用MVI打造响应式APP[七]:Timing,SingleLiveEventProblem](https://github.com/qingmei2/android-programming-profile/blob/master/src/Android-MVI/%5B%E8%AF%91%5D%E4%BD%BF%E7%94%A8MVI%E6%89%93%E9%80%A0%E5%93%8D%E5%BA%94%E5%BC%8FAPP%5B%E4%B8%83%5D%3ATiming%2CSingleLiveEventProblem.md)
> * [[译]使用MVI打造响应式APP[八]:Navigation](https://github.com/qingmei2/android-programming-profile/blob/master/src/Android-MVI/%5B%E8%AF%91%5D%E4%BD%BF%E7%94%A8MVI%E6%89%93%E9%80%A0%E5%93%8D%E5%BA%94%E5%BC%8FAPP%5B%E5%85%AB%5D%3ANavigation.md)

## 感谢

:art: 项目中的UI设计部分参考了 [gitme](https://github.com/flutterchina/gitme) .

:star: 感谢 [oldergod/android-architecture](https://github.com/oldergod/android-architecture) 项目对本项目的指导性作用.

## License

    The MVI-Rhine: Apache License

    Copyright (c) 2019 qingmei2

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
