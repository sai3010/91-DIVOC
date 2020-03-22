package com.hackertronix.divocstats.overview

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hackertronix.data.repository.OverviewRepository
import com.hackertronix.model.overview.Overview
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.plusAssign
import io.reactivex.rxkotlin.subscribeBy

class OverviewViewModel(private val repository: OverviewRepository) : ViewModel() {

    private val overviewObservable: Observable<Overview> = repository.getOverview()
    private val overviewLiveData = MutableLiveData<Overview>()
    private val errorLiveData = MutableLiveData<String>()
    private val disposables = CompositeDisposable()

    init {
        disposables += overviewObservable.subscribeBy(
            onNext = {
                overviewLiveData.postValue(it)
            },
            onError = {
               errorLiveData.postValue(it.message)
            }
        )
    }

    fun getOverview(): LiveData<Overview> = overviewLiveData

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }
}