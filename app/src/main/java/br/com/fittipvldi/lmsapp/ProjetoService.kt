package br.com.fittipvldi.lmsapp

import android.graphics.drawable.Drawable

object ProjetoService {

    fun getProjetos(): List<Projeto> {

        var projetos = mutableListOf<Projeto>()

        val clientes = listOf<String>("Bullest", "Santander", "Supera", "Banco Daycoval", "Banco Alpha")
        var projetosNome = listOf<String>("Landpage", "Santander Caceis", "CRM4U", "Originals", "Alpha")
        var fotos = listOf<String>(
                "http://bullest.com.br/assets/img/logos/logo-bullest-banner.png",
                "https://logodownload.org/wp-content/uploads/2017/05/santander-logo-1.png",
                "http://crm4u.azurewebsites.net/Content/assets/dist/img/logo.png",
                "https://institutomontanari.com.br/wp-content/uploads/2020/12/Banco-Daycoval-1.png",
                "https://apamagis.com.br/institucional/wp-content/uploads/2019/05/BANCO-ALFA-1.jpg"
        )

        var imgs = listOf<Int>(
                R.drawable.logo_bullest_blue,
                R.drawable.santander,
                R.drawable.crm,
                R.drawable.daycoval,
                R.drawable.alpha
        )

//        var imgs = listOf<Integer>{R.drawable.logo_bullest_blue, R.}
    var count:Long = 1
        for (i in 0..4  ) {
            val d = Projeto()
            d.nome = projetosNome[i]
            d.cliente = clientes[i]
            d.foto = fotos[i]
            d.id = count
            d.img = imgs[i]
            projetos.add(d)
            count++
        }
        for (i in 0..4) {
            val d = Projeto()
            d.nome = projetosNome[i]
            d.cliente = clientes[i]
            d.foto = fotos[i]
            d.id = count
            projetos.add(d)
            count++
        }
        return projetos

    }

}