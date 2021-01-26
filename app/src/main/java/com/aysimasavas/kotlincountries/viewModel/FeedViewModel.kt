package com.aysimasavas.kotlincountries.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.aysimasavas.kotlincountries.model.Country

class FeedViewModel: ViewModel() {

    val countries= MutableLiveData<List<Country>>()
    val countryError=MutableLiveData<Boolean>()
    val countryLoading=MutableLiveData<Boolean>()


    fun refreshData()
    {

        val country=Country("Turkey","Asia","Ankara","TRY","Turkish",".com")
        val country2=Country("Almanya","Europ","Ankara","TRY","Turkish",".com")
        val country3=Country("Fransa","Europe","Ankara","TRY","Turkish",".com")

        val countryList= arrayListOf<Country>(country,country2,country3)

        countries.value=countryList
        countryError.value=false
        countryLoading.value=false


    }

}