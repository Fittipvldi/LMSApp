package br.com.fittipvldi.lmsapp

object ProjetoService {

    fun getProjetos(): List<Projeto> {

        var projetos = mutableListOf<Projeto>()

        for (i in 1..10) {
            val d = Projeto()
            d.nome = "Projeto $i"
            d.cliente = "Cliente $i"
            d.foto = "https://marcas-logos.net/wp-content/uploads/2020/02/Santander-Logo.png"
            projetos.add(d)
        }

        return projetos

    }

}