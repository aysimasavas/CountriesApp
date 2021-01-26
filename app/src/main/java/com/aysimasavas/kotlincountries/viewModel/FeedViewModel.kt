package com.aysimasavas.kotlincountries.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aysimasavas.kotlincountries.model.Country
import com.aysimasavas.kotlincountries.service.CountryAPIService
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class FeedViewModel: ViewModel() {


    private val countryAPIService = CountryAPIService()

    private val disposible= CompositeDisposable() //kullan at objesi

    val countries= MutableLiveData<List<Country>>()
    val countryError=MutableLiveData<Boolean>()
    val countryLoading=MutableLiveData<Boolean>()


    fun refreshData()
    {

        getDataFromAPI()

    }

    private fun getDataFromAPI()
    {

        countryLoading.value=true

        disposible.add(
                countryAPIService.getData()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(object : DisposableSingleObserver<List<Country>>(){
                            override fun onSuccess(t: List<Country>) {
                                countries.value=t
                                countryError.value=false
                                countryLoading.value=false
                            }

                            override fun onError(e: Throwable) {
                                countryLoading.value=false
                                countryError.value=true
                                e.printStackTrace()
                            }

                        })
        )
    }

}