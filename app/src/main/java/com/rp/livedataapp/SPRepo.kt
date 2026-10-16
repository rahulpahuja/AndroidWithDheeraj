package com.rp.livedataapp

import android.content.Context

public class SharedPreferencesRepository(context: Context){
    private val sharedPreferences = context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()


    //Whats the problem with Shared Preferences
    fun saveData(key: String, value: String) {
        editor.putString(key, value)

        editor.apply() //Async write is partially written
    }

    fun getData(key: String, defaultValue: String): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    //Async and Multi Threading
}

