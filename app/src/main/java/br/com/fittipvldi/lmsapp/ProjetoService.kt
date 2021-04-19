package br.com.fittipvldi.lmsapp

object ProjetoService {

    fun getProjetos(): List<Projeto> {

        var projetos = mutableListOf<Projeto>()

        val fotos = listOf("https://marcas-logos.net/wp-content/uploads/2020/02/Santander-Logo.png", "https://www.jornalcontabil.com.br/wp-content/uploads/2020/04/bradesco-768x538-1-600x420.png", "https://www.jornalcontabil.com.br/wp-content/uploads/2018/11/concurso-pu%CC%81blico-bb-cursodememorizac%CC%A7a%CC%83o-2.jpg")

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