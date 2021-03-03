package br.com.fittipvldi.lmsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*

class MainActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        imagem_login.setImageResource(R.drawable.imagem_login)

        botao_login.setOnClickListener {
            Toast.makeText(this, "Clicado!", Toast.LENGTH_SHORT).show()

            val nomeUsuario = campo_usario.text.toString()

            val intent = Intent(this, TelaInicialActivity::class.java)
            val params = Bundle()
            params.putString("nome", nomeUsuario)
            intent.putExtras(params)

            startActivity(intent)
        }
    }
}