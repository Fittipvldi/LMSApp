package br.com.fittipvldi.lmsapp

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class ProjetoAdapter(

    val projetos: List<Projeto>,
    val onClick: (Projeto) -> Unit

): RecyclerView.Adapter<ProjetoAdapter.ProjetosViewHolder>() {

    class ProjetosViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val cardNome: TextView
        val cardImage: ImageView
        val cardProgress: ProgressBar
        val cardView: CardView

        init {
            cardNome = view.findViewById(R.id.card_nome)
            cardImage = view.findViewById(R.id.card_image)
            cardProgress = view.findViewById(R.id.card_progress)
            cardView = view.findViewById(R.id.card_progress)
        }

    }

    override fun getItemCount() = this.projetos.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ProjetosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_projeto, parent, false)

        val holder = ProjetosViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: ProjetosViewHolder, position: Int) {

        val projeto = projetos[position]

        holder.cardNome.text = projeto.nome
        holder.cardProgress.visibility = View.VISIBLE



    }

}