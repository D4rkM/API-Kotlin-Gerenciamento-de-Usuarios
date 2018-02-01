package com.example.a16254861.apikotlin

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.JsonReader
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import org.json.JSONObject
import org.json.JSONStringer
import java.net.URL

class MainActivity : AppCompatActivity() {

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text_cad.setOnClickListener{
//            val intent = Intent(this, Main2Activity::class.java)
            startActivity<Main2Activity>()
        }

        val pref = getSharedPreferences("senai", Context.MODE_PRIVATE)

        val nomeLogado = pref.getString("nome", "")

        if(nomeLogado.isNotEmpty()){
            startActivity<Main>()
            finish()
        }

        btn_login.setOnClickListener{
            val user = txt_usuario.text.toString()
            val senha = txt_senha.text.toString()
            //GET
            /*doAsync{

                val resultado = URL("http://10.0.2.2/APIKotlin/api.php?user=$user&senha=$senha").readText()


                val retornoJson = JSONObject(resultado)

                val resposta = retornoJson.getBoolean("sucesso")

                uiThread {

                    if(resposta){
                        toast("Bem vindo")
                        startActivity<Main>()
                    }else{
                        toast("usuario nao existe")
                    }

                }

            }*/
            //POST
            /*doAsync {
                val map = HashMap<String, String>()

                map.put("usuario", user)
                map.put("senha", senha)

                val resultado = HttpConnection.post("http://10.0.2.2/APIKotlin/api.php", map)

                Log.d("API", resultado)

                val retornoJson = JSONObject(resultado)

                val resposta = retornoJson.getBoolean("sucesso")

                uiThread {
                    if (resposta) {
                        toast("Bem vindo")
                        startActivity<Main>()
                    } else {
                        toast("usuario nao existe")
                    }
                }

            }*/
//            doAsync {
//
//                val urlBuilder = HttpUrl.parse("http://10.0.2.2/APIKotlin/api.php")!!.newBuilder()
//
//                urlBuilder.addQueryParameter("usuario", user)
//                urlBuilder.addQueryParameter("senha", senha)
//
//                val url = urlBuilder.build().toString()
//
//                val request = Request.Builder().url(url).build()
//
//                val retornoJson = (request)
//
//                val resposta = retornoJson.getBoolean("sucesso")
//
//                uiThread {
//                    if (resposta) {
//                        toast("Bem vindo")
//                        startActivity<Main>()
//                    } else {
//                        toast("usuario nao existe")
//                    }
//                }
//
//            }

            if (user.equals("senai") && senha.equals("senha")){
                val pref = getSharedPreferences("senai", Context.MODE_PRIVATE)
                val edit = pref.edit()
                //grava o nome do user na chave nome
                pref.edit().putString("nome",user).apply()
                pref.edit().putString("senha",senha).apply()

                edit.apply()
                startActivity<Main>()
            }


        }

    }
}
