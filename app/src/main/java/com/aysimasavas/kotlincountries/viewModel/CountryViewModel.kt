package com.aysimasavas.kotlincountries.viewModel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aysimasavas.kotlincountries.model.Country
import com.aysimasavas.kotlincountries.service.CountryDatabase
import kotlinx.coroutines.launch

class CountryViewModel(application: Application):BaseViewModel(application) {
    val countryLiveData=MutableLiveData<Country>()

    fun getDataFromRoom(uuid:Int)
    {

        launch {
            val dao=CountryDatabase(getApplication()).countryDao()
            val country=dao.getCountry(uuid)
            countryLiveData.value=country
        }

    }
}