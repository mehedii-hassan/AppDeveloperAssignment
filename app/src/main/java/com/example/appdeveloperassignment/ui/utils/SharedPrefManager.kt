package com.example.appdeveloperassignment.ui.utils

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Configuration
import com.example.appdeveloperassignment.data.BookListResponse
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.Locale


object SharedPrefManager {

    private const val PREFS_NAME = "OPUS_EMPLOYER"
    private const val KEY_SEARCH_BY_KEYWORD = "KEYWORD"
    private const val KEY_COUNTRY_NAME = "COUNTRY_NAME"
    private const val KEY_ADAPTER_POS = "ADAPTER_POS"
    private const val KEY_FILTERED_JOB_LIST = "FILTERED_JOB_LIST"
    private const val KEY_FILTER_MODEL = "FILTER_MODEL"
    private const val KEY_PAYMENT_FAILED = "FAILED"
    private const val KEY_LANGUAGE = "language code"
    private const val KEY_ACCESS_TOKEN = "access_token"
    private const val KEY_FCM_TOKEN = "fcm_token"
    private const val KEY_MODEL = "model"
    private const val KEY_ALL_CANDIDATES = "all_candidates_model"
    private const val KEY_FAVORITE_CANDIDATES = "favorite_candidates_model"
    private const val KEY_FORGOT_PASSWORD_EMAIL = "forgot_password_email"
    private const val KEY_OTP = "otp"
    private const val KEY_EMPLOYER_ID = "id"
    private const val KEY_CANDIDATE_ID = "candidate_id"
    private const val KEY_EMPLOYER_UUID = "uuid"
    private const val KEY_JOB_UUID = "job_uuid"
    private const val KEY_JOB_ID = "job_id"
    private const val KEY_CANDIDATE_UUID = "candidate_uuid"
    private const val KEY_REMOVE_CANDIDATE_UUID = "remove_candidate_uuid"
    private const val KEY_JOB_TITLE = "job_title"
    private const val KEY_APPLICATION_UUID = "selected_uuid"
    private const val KEY_IS_SELECTED = "is_selected"
    private const val KEY_IS_FAVORITE = "is_favorite"
    private const val KEY_CANDIDATE_STATUS = "Shortlisted"
    private const val KEY_FAVORITE_CANDIDATE_UUID = "favorite_candidate_uuid"
    private const val KEY_TAB_LAYOUT_ITEM_CLICKED_COUNT = "CLICKED_COUNT"
    private const val KEY_BUNDLE = "KEY_BUNDLE"


    //Initialize SharedPreferences
    private fun getSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    //Save keyword to SharedPreferences----------------------------------------------------
    fun saveBundleValue(context: Context, key: String) {
        val editor = getSharedPreferences(context).edit()
        editor.putString(KEY_BUNDLE, key)
        editor.apply()
    }


    //Save favorite candidates model to SharedPreferences----------------------------------------------------


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


    // Clear all from SharedPreferences
    fun clearAllModelClass(context: Context) {
        val editor = getSharedPreferences(context).edit()
        editor.remove(KEY_MODEL)
        editor.remove(KEY_ALL_CANDIDATES)
        editor.remove(KEY_FAVORITE_CANDIDATES)
        editor.apply()
    }

    fun clearFilteredJobList(context: Context) {
        val editor = getSharedPreferences(context).edit()
        editor.remove(KEY_FILTERED_JOB_LIST)
        editor.apply()
    }

    // Clear all from SharedPreferences
    fun clearAll(context: Context) {
        val editor = getSharedPreferences(context).edit()
        //editor.remove(KEY_LANGUAGE)
        editor.remove(KEY_ACCESS_TOKEN)
        editor.remove(KEY_FORGOT_PASSWORD_EMAIL)
        editor.remove(KEY_OTP)
        editor.remove(KEY_EMPLOYER_ID)
        editor.remove(KEY_EMPLOYER_UUID)
        editor.remove(KEY_JOB_UUID)
        editor.remove(KEY_CANDIDATE_UUID)
        editor.remove(KEY_JOB_TITLE)
        editor.remove(KEY_CANDIDATE_ID)
        editor.remove(KEY_APPLICATION_UUID)
        editor.remove(KEY_IS_SELECTED)
        editor.remove(KEY_IS_FAVORITE)
        editor.remove(KEY_REMOVE_CANDIDATE_UUID)
        editor.remove(KEY_FAVORITE_CANDIDATE_UUID)
        editor.remove(KEY_MODEL)
        editor.remove(KEY_ALL_CANDIDATES)
        editor.remove(KEY_FAVORITE_CANDIDATES)
        editor.remove(KEY_JOB_ID)
        editor.remove(KEY_ADAPTER_POS)
        editor.remove(KEY_TAB_LAYOUT_ITEM_CLICKED_COUNT)
        editor.remove(KEY_BUNDLE)
        editor.apply()
    }


}