package com.aysimasavas.kotlincountries.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.aysimasavas.kotlincountries.R
import com.aysimasavas.kotlincountries.adapter.CountryAdapter
import com.aysimasavas.kotlincountries.viewModel.FeedViewModel
import kotlinx.android.synthetic.main.fragment_feed.*


class FeedFragment : Fragment() {

    private lateinit var viewModel:FeedViewModel
    private  var countryAdapter= CountryAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //nerede olduğunu ve hangi model classla çalışmak istediğini yazarsın
        viewModel=ViewModelProviders.of(this).get(FeedViewModel::class.java)
        viewModel.refreshData()

        countryList.layoutManager=LinearLayoutManager(context)
        countryList.adapter=countryAdapter


        observeLiveData()


    }

    private fun observeLiveData()
    {
        viewModel.countries.observe(viewLifecycleOwner, Observer { countries->

            countries?.let {
                countryList.visibility=View.VISIBLE
                countryAdapter.updateCountryList(countries)
            }



        })

        viewModel.countryError.observe(viewLifecycleOwner, Observer { error->

            error?.let {
                if(it)
                {
                   country_error_text.visibility=View.VISIBLE
                    countryList.visibility=View.GONE

                }
                else{
                    country_error_text.visibility=View.GONE
                }
            }
        })

        viewModel.countryLoading.observe(viewLifecycleOwner, Observer { loading->

            loading?.let {

                if(it)
                {
                  countryLoading.visibility=View.VISIBLE
                    countryList.visibility=View.GONE
                    country_error_text.visibility=View.GONE

                }
                else
                {
                    countryLoading.visibility=View.GONE
                }
            }
        })
    }

}