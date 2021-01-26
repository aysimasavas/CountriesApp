package com.aysimasavas.kotlincountries.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aysimasavas.kotlincountries.model.Country

class CountryViewModel:ViewModel() {
    val countryLiveData=MutableLiveData<Country>()


    fun getDataFromRoom()
    {

        val country=Country("Turkey","Asia","Ankara","TRY","Turkish",".com")
        countryLiveData.value=country

    }
}