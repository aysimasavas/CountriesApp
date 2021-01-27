package com.aysimasavas.kotlincountries.service
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.aysimasavas.kotlincountries.model.Country


@Dao
interface CountryDao {

    //data accsess object
    @Insert
    suspend fun insertAll(vararg countries: Country):List<Long>

//insert-> INSERT INTO
//suspend-> coroutine, pause & resume
//vararg -> multiple country object döndürür
//List<Long>  ->  primary keys döndürü

    @Query("SELECT * FROM country")
    suspend fun  getAllCountries():List<Country>

    @Query("SELECT *FROM country WHERE uuid = :countryId")
    suspend fun  getCountry(countryId:Int):Country


    @Query("DELETE FROM country")
    suspend fun deleteAllCountries()


}