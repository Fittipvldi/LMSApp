package br.com.fittipvldi.lmsapp


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaInicialActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val context: Context get() = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        var params = intent.extras
        val nome = params?.getString("nome")
        Toast.makeText(this, "Bem-vindo $nome", Toast.LENGTH_SHORT).show()

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Projetos"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        confuguraMenuLateral()

        recycler_projetos?.layoutManager = LinearLayoutManager(this)

    }

    private var projetos = listOf<Projeto>()

    override fun onResume() {
        super.onResume()
        projetos = ProjetoService.getProjetos()
        recycler_projetos?.adapter = ProjetoAdapter(projetos) {
            onClickProjeto(it)
        }
    }

    fun onClickProjeto(projeto: Projeto) {
        Toast.makeText(this, "Clicou projeto ${projeto.nome}", Toast.LENGTH_SHORT).show()
    }

    private fun confuguraMenuLateral() {
        var toogle = ActionBarDrawerToggle(
            this,
            layout_menu_lateral,
            toolbar,
            R.string.nav_open,
            R.string.nav_close
        )

        layout_menu_lateral.addDrawerListener(toogle)
        toogle.syncState()

        nav_menu_lateral.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_projetos -> {
                val intent = Intent(this, TelaInicialActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Clicou em Projetos", Toast.LENGTH_LONG).show()
            }
            R.id.nav_relatorios -> {
                val intent = Intent(this, RelatoriosActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Clicou em Relatórios", Toast.LENGTH_LONG).show()
            }
            R.id.nav_sobre -> {
                val intent = Intent(this, SobreActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Clicou em Sobre", Toast.LENGTH_LONG).show()
            }
            R.id.nav_localizacao -> {
                val intent = Intent(this, LocalizacaoActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Clicou em Localização", Toast.LENGTH_LONG).show()
            }

            R.id.nav_sair -> {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(this, "Clicou em Sair", Toast.LENGTH_LONG).show()
            }

        }

        layout_menu_lateral.closeDrawer(GravityCompat.START)

        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if(id == R.id.action_buscar) {
            Toast.makeText(this, "Clicou Buscar!", Toast.LENGTH_SHORT).show()
        } else if(id == R.id.action_atualizar) {
            Toast.makeText(this, "Clicou em Atualizar!", Toast.LENGTH_SHORT).show()
        } else if(id == R.id.action_config) {
            Toast.makeText(this, "Clicou em Configurações!", Toast.LENGTH_SHORT).show()
        } else if(id == android.R.id.home) {
            finish()
        }
        return  super.onOptionsItemSelected(item)
    }
}