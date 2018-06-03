package com.googry.sushicount.data.source

import io.reactivex.disposables.CompositeDisposable

abstract class BaseRepository: BaseDataSource {
    protected val compositeDisposable = CompositeDisposable()

    override fun onCleared() {
        compositeDisposable.clear()
    }
}