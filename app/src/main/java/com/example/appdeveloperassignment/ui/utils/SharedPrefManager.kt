package com.example.appdeveloperassignment.ui.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.appdeveloperassignment.data.BookListResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


object SharedPrefManager {

    private const val PREFS_NAME = "OPUS_EMPLOYER"
    private const val KEY_FILTERED_JOB_LIST = "FILTERED_JOB_LIST"
    private const val Key_limit = "limit"


    //Initialize SharedPreferences
    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }


    fun saveBooksLimit(context: Context, limit: Int) {
        val editor = getSharedPreferences(context).edit()
        editor.putInt(Key_limit, limit)
        editor.apply()
    }


    //Get keyword from SharedPreferences----------------------------------------------------
    fun getBooksLimit(context: Context): Int {
        return getSharedPreferences(context).getInt(Key_limit, 0)
    }

    //Save favorite candidates model to SharedPreferences----------------------------------------------------
    fun saveFilterJobList(
        context: Context,
        filteredJobList: List<BookListResponse.BookListResponseItem>
    ) {
        val editor = getSharedPreferences(context).edit()
        val gson = Gson()
        val json: String = gson.toJson(filteredJobList)
        editor.putString(KEY_FILTERED_JOB_LIST, json)
        editor.apply()
    }


    //Get all candidates model  from SharedPreferences----------------------------------------------------
    fun getFilterJobList(context: Context): List<BookListResponse.BookListResponseItem>? {
        val gson = Gson()
        val json = getSharedPreferences(context).getString(KEY_FILTERED_JOB_LIST, null)

        val type: Type = object : TypeToken<List<BookListResponse.BookListResponseItem>>() {}.type
        return gson.fromJson(json, type)
    }


    fun clearFilteredJobList(context: Context) {
        val editor = getSharedPreferences(context).edit()
        editor.remove(Key_limit)
        editor.apply()
    }


}