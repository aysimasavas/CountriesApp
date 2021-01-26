package com.aysimasavas.kotlincountries.service

import com.aysimasavas.kotlincountries.model.Country
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class CountryAPIService {


    //BASE_URL ->https://raw.githubusercontent.com/
    //Ext->atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json


    private val BASE_URL="https://raw.githubusercontent.com/"

    private val api= Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(CountryApi::class.java)


    fun getData() : Single<List<Country>>
    {

        return api.getCountries()
    }

}