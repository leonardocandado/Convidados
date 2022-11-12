package com.udemy.convidados.view.viewHolder

import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.udemy.convidados.databinding.RowGuestBinding
import com.udemy.convidados.model.GuestModel
import com.udemy.convidados.view.listener.OnGuestListener

class GuestViewHolder(private val bind: RowGuestBinding, private val listener: OnGuestListener) :
    RecyclerView.ViewHolder(bind.root) {

    fun bind(guest: GuestModel) {
        // Atribui valores
        bind.textName.text = guest.name

        // Atribui eventos
        bind.textName.setOnClickListener {
            listener.onClick(guest.id)
        }

        // Atribui eventos
        bind.textName.setOnLongClickListener {
            AlertDialog.Builder(itemView.context)
                .setTitle("Remover")
                .setMessage("Confirmar remoção")
                .setNegativeButton("Não", null)
                .setPositiveButton("Sim") { dialog, wich -> listener.onDelete(guest.id) }
                .create()
                .show()

            true
        }
    }
}