package br.com.fittipvldi.lmsapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*

class TelaInicialActivity : DebugActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        var params = intent.extras
        val nome = params?.getString("nome")
        Toast.makeText(this, "Bem-vindo $nome", Toast.LENGTH_SHORT).show()
    }
}