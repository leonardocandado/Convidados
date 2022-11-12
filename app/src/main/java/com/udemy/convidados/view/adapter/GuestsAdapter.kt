package com.udemy.convidados.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.udemy.convidados.databinding.RowGuestBinding
import com.udemy.convidados.model.GuestModel
import com.udemy.convidados.view.listener.OnGuestListener
import com.udemy.convidados.view.viewHolder.GuestViewHolder

class GuestsAdapter : RecyclerView.Adapter<GuestViewHolder>() {

    // Lista de convidados
    private var listGuest: List<GuestModel> = arrayListOf()
    private lateinit var listener: OnGuestListener

    /**
     * Faz a criação do layout da linha
     * Faz a criação de várias linhas que vão mostrar cada um dos convidados
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuestViewHolder {
        val item = RowGuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GuestViewHolder(item, listener)
    }


    /**
     * Para cada linha, este método é chamado
     * É responsável por atribuir os valores de cada item para uma linha específica
     */
    override fun onBindViewHolder(holder: GuestViewHolder, position: Int) {
        holder.bind(listGuest[position])
    }

    /**
     * Qual o tamanho da RecyclerView
     */
    override fun getItemCount(): Int {
        return listGuest.count()
    }

    /**
     * Atualização da lista de convidados
     */
    fun updateGuests(list: List<GuestModel>) {
        listGuest = list
        notifyDataSetChanged()
    }

    /**
     * Eventos na listagem
     */
    fun attachListener(guestListener: OnGuestListener) {
        listener = guestListener
    }
}