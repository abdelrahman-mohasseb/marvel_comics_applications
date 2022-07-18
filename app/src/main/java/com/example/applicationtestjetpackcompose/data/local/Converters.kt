package com.example.applicationtestjetpackcompose.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.applicationtestjetpackcompose.data.util.JsonParser
import com.example.applicationtestjetpackcompose.domain.model.Creator
import com.example.applicationtestjetpackcompose.domain.model.Date
import com.google.gson.reflect.TypeToken

@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    @TypeConverter
    fun fromCreatorsJson(json: String): List<Creator> {
        return jsonParser.fromJson<ArrayList<Creator>>(
            json,
            object : TypeToken<ArrayList<Creator>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toCreatorsJson(creators: List<Creator>): String {
        return jsonParser.toJson(
            creators,
            object : TypeToken<ArrayList<Creator>>(){}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromCharacterJson(json: String): List<String> {
        return jsonParser.fromJson<ArrayList<String>>(
            json,
            object : TypeToken<ArrayList<String>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toCharactersJson(characters: List<String>): String {
        return jsonParser.toJson(
            characters,
            object : TypeToken<ArrayList<String>>(){}.type
        ) ?: "[]"
    }



    @TypeConverter
    fun fromPricesJson(json: String): List<Int> {
        return jsonParser.fromJson<ArrayList<Int>>(
            json,
            object : TypeToken<ArrayList<Int>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toPricesJson(prices: List<Int>): String {
        return jsonParser.toJson(
            prices,
            object : TypeToken<ArrayList<Int>>(){}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromDateJson(json: String): List<Date> {
        return jsonParser.fromJson<ArrayList<Date>>(
            json,
            object : TypeToken<ArrayList<Date>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toDatesJson(dates: List<Date>): String {
        return jsonParser.toJson(
            dates,
            object : TypeToken<ArrayList<Date>>(){}.type
        ) ?: "[]"
    }
}