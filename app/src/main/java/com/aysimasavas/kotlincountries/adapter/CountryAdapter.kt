package com.aysimasavas.kotlincountries.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.aysimasavas.kotlincountries.R
import com.aysimasavas.kotlincountries.model.Country
import com.aysimasavas.kotlincountries.view.FeedFragmentDirections
import kotlinx.android.synthetic.main.item_country_recyc.view.*

class CountryAdapter(val countryList: ArrayList<Country>): RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
       val inflater =LayoutInflater.from(parent.context)
        val view=inflater.inflate(R.layout.item_country_recyc,parent,false)

        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.view.name_text.text=countryList[position].countryName
        holder.view.region_text.text=countryList[position].countryRegion


        holder.view.setOnClickListener {
            val action=FeedFragmentDirections.actionFeedFragmentToCountryFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return countryList.size
    }

    class CountryViewHolder(var view: View):RecyclerView.ViewHolder(view) {


    }

    fun updateCountryList(newCountryList:List<Country>)
    {

        countryList.clear()
        countryList.addAll(newCountryList)
        notifyDataSetChanged()

    }
}




