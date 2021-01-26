package com.aysimasavas.kotlincountries.service

import com.aysimasavas.kotlincountries.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountryApi {

    //https://raw.githubusercontent.com/atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json
    //GET,POST
    //BASE_URL ->https://raw.githubusercontent.com/
    //Ext->atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json
    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    fun getCountries():Single<List<Country>>



    //Single sadece bir defa alır ve bu işi yapar,bir defa alıp garanti bir şekilde almamız gerekiyorsa
    //Observable durmadan devamlı internetten verileri alır ,,devamlı veri almamız gerekiyosa
}