package com.aysimasavas.kotlincountries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.aysimasavas.kotlincountries.R
import com.aysimasavas.kotlincountries.databinding.FragmentCountryBinding
import com.aysimasavas.kotlincountries.util.downloadFromUrl
import com.aysimasavas.kotlincountries.util.placeHolderProgressBar
import com.aysimasavas.kotlincountries.view.CountryFragmentArgs
import com.aysimasavas.kotlincountries.viewModel.CountryViewModel
import kotlinx.android.synthetic.main.fragment_country.*


class CountryFragment : Fragment() {


    private lateinit var viewModel:CountryViewModel

    private var countryUuId=0

    private lateinit var databinding: FragmentCountryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        databinding= DataBindingUtil.inflate(inflater,R.layout.fragment_country,container,false)

        return databinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {

            countryUuId= CountryFragmentArgs.fromBundle(it).countryUuId

        }
        viewModel=ViewModelProviders.of(this).get(CountryViewModel::class.java)
        viewModel.getDataFromRoom(countryUuId)


        observeLiveData()

    }

    private fun observeLiveData()
    {
        viewModel.countryLiveData.observe(viewLifecycleOwner, Observer { country->

            country?.let {

                databinding.selectedCountry=it

                /*country_name_text.text=country.countryName
                country_language_text.text=country.countryLanguage
                region_name_text.text=country.countryRegion
                capital_name_text.text=country.countryCapital
                currency_text.text=country.countryCurrency

                context?.let {
                    country.flag?.let { it1 -> country_image.downloadFromUrl(it1, placeHolderProgressBar(it)) }
                }*/

            }
        })
    }
}