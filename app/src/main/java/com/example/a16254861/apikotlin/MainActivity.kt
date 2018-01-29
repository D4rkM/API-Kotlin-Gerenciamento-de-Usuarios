package com.example.a16254861.apikotlin

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import org.json.JSONObject
import java.net.URL

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text_cad.setOnClickListener{
//            val intent = Intent(this, Main2Activity::class.java)
            startActivity<Main2Activity>()
        }

        btn_login.setOnClickListener{
            var user = txt_usuario.text.toString()
            var senha = txt_senha.text.toString()
            
            doAsync{

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

            }

        }

    }
}
