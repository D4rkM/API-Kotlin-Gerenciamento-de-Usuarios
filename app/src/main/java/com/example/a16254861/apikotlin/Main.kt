package com.example.a16254861.apikotlin

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.service.carrier.CarrierMessagingService
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main3.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class Main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val pref = getSharedPreferences("senai", Context.MODE_PRIVATE)

        val nome = pref.getString("nome", "")
        val senha = pref.getString("senha", "")

        toast("Bem vindo $nome")

        logout.setOnClickListener(){
            pref.edit().remove("nome").apply()
            pref.edit().remove("senha").apply()

            startActivity<MainActivity>()
            finish()

        }

    }
}
