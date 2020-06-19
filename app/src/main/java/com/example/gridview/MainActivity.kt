package com.example.gridview

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {
    var adapter: TinderAdapter? = null
    var arr = ArrayList<Model>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        arr = getArrayList("list")
        val bundle: Bundle? = intent.extras
        adapter = TinderAdapter(this, arr)
        gvTinder.adapter = adapter
    }
    fun saveArrayList(list: ArrayList<Model>, key: String?) {
        val sharedPref: SharedPreferences = getSharedPreferences("list", 0)
        val editor: SharedPreferences.Editor = sharedPref.edit()
        val gson = Gson()
        val json: String = gson.toJson(list)
        editor.putString(key, json)
        editor.apply()
    }
    fun getArrayList(key: String?): ArrayList<Model> {
        val sharedPref: SharedPreferences = getSharedPreferences("list", 0)
        val gson = Gson()
        val json: String? = sharedPref.getString(key, null)
        val type: Type = object : TypeToken<ArrayList<Model>>() {}.getType()
        return gson.fromJson(json, type)
    }
}
