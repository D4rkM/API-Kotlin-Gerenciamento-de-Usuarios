package com.example.a16254861.apikotlin

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.content_main2.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import org.json.JSONObject

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        salvar.setOnClickListener(){

            val usuario = cadUser.text.toString()
            var sexo = cadSex.checkedRadioButtonId.toString()
            val senha = cadPass.text.toString()

            if(sexo.equals("1")){
                sexo = "M"
            }else{
                sexo = "F"
            }

            doAsync {
                val map = HashMap<String, String>()

                map.put("usuario", usuario)
                map.put("senha", senha)
                map.put("sexo", sexo)

                val resultado = HttpConnection.post("http://10.0.2.2/APIKotlin/insert.php", map)

                val retornoJson = JSONObject(resultado)

                val resposta = retornoJson.getBoolean("sucesso")

                uiThread {
                    if (resposta) {
                        toast("Cadastro efetuado com sucesso")
                        finish()
                    } else {
                        toast("Não foi possível cadastrar o Usuário")
                    }
                }

            }

        }


    }

}
