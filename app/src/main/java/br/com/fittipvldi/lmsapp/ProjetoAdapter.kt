package br.com.fittipvldi.lmsapp

import android.annotation.SuppressLint
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.net.URI

class ProjetoAdapter(

    val projetos: List<Projeto>,
    val onClick: (Projeto) -> Unit

): RecyclerView.Adapter<ProjetoAdapter.ProjetosViewHolder>() {

    class ProjetosViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val cardNome: TextView
        val cardImage: ImageView
        val cardProgress: ProgressBar
        val cardView: CardView
        val cardId: TextView
        val cardCliente: TextView

        init {
            cardNome = view.findViewById(R.id.card_nome)
            cardImage = view.findViewById(R.id.card_image)
            cardProgress = view.findViewById(R.id.card_progress)
            cardView = view.findViewById(R.id.card_projetos)
            cardId = view.findViewById(R.id.card_id_codigo)
            cardCliente = view.findViewById(R.id.card_cliente)
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
        holder.cardCliente.text = projeto.cliente
        holder.cardId.text = projeto.id.toString()

        //var imgUri:Uri = Uri.parse(projeto.foto)
        //holder.cardImage.setImageURI(imgUri)

        // holder.cardImage.setImageResource(R.drawable.logo_bullest_blue)

        holder.cardProgress.visibility = View.VISIBLE

        val context = holder.itemView.context
        Picasso.with(context).load(projeto.img).fit().into(holder.cardImage,
        // Picasso.with(context).load(projeto.foto).into(holder.cardImage,
                object : com.squareup.picasso.Callback {

                    @SuppressLint("ResourceAsColor")
                    override fun onSuccess() {
                        holder.cardProgress.visibility = View.GONE
                        println("success")
                        holder.cardImage.setBackgroundColor(R.color.transparent)
                    }

                    override fun onError() {
                        println("erro")
                        holder.cardImage.setImageResource(R.drawable.imagem_login)
                        holder.cardProgress.visibility = View.GONE
                    }

                })

    }

}