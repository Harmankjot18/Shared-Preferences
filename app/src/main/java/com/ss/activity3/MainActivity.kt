package com.ss.activity3

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var sharedPreferences : SharedPreferences
    lateinit var editor : SharedPreferences.Editor
    lateinit var et1 : EditText
    lateinit var btn1 : Button
    lateinit var btn2 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        et1 = findViewById(R.id.et1)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        sharedPreferences =getSharedPreferences(resources.getString(R.string.app_name),
            Context.MODE_PRIVATE)
        editor= sharedPreferences.edit()
        if (sharedPreferences.contains("Data")){
            et1.setText(sharedPreferences.getString("Data",""))
        }
        btn1.setOnClickListener {
            if (et1.text.isNullOrEmpty()==false){
              editor.putString("Data",et1.text.toString())
                editor.apply()
            }
            else{
                Toast.makeText(this ,"enter value to save",Toast.LENGTH_LONG).show()
            }
        }
        btn2.setOnClickListener {
            editor.clear()
            editor.commit()
        }
    }
}