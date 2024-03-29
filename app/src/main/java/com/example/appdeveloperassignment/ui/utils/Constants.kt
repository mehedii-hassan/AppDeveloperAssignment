package com.example.appdeveloperassignment.ui.utils

import android.content.Context
import com.example.appdeveloperassignment.data.BookListResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object Constants {


    fun readJsonFromAssets(context: Context, fileName: String): String {
        return context.assets.open(fileName).bufferedReader().use { it.readText() }
    }

    fun parseJsonToModel(jsonString: String): List<BookListResponse.BookListResponseItem> {
        val gson = Gson()
        return gson.fromJson(
            jsonString,
            object : TypeToken<List<BookListResponse.BookListResponseItem>>() {}.type
        )
    }
}