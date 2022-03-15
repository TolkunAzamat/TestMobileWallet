package com.example.testmobilewallet

import android.content.Context
import android.content.SharedPreferences

class SharedPreference (context: Context) {
    private val APP_NAME="SharedPreference"
    private var pref: SharedPreferences
    init{
        pref=context.getSharedPreferences(APP_NAME, Context.MODE_PRIVATE)

    }
    var login:String?
        get()=pref.getString("login",null)
        set(value)=pref.edit().putString("login",value).apply ()
    var password:String?
        get()=pref.getString("password",null)
        set(value)=pref.edit().putString("password",value).apply ()
}