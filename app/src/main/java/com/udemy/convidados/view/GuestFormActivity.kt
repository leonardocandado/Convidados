package com.udemy.convidados.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.udemy.convidados.R
import com.udemy.convidados.constants.Constants
import com.udemy.convidados.databinding.ActivityGuestFormBinding
import com.udemy.convidados.model.GuestModel
import com.udemy.convidados.viewModel.GuestFormViewModel

class GuestFormActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityGuestFormBinding
    private lateinit var viewModel: GuestFormViewModel
    private var guestId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(GuestFormViewModel::class.java)

        binding.buttonSave.setOnClickListener(this)
        // Cria observadores
        observe()

        // Carrega dados do usuário, caso haja
        loadData()

        // Default
        binding.radioPresent.isChecked = true
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_save) {
            val name = binding.editName.text.toString()
            val presence = binding.radioPresent.isChecked
            //val model = GuestModel(guestId, name, presence)
            val model = GuestModel().apply {
                this.id = guestId
                this.name = name
                this.presence = presence
            }
            viewModel.save(model)
        }
    }

    private fun loadData() {
        val bundle = intent.extras
        if (bundle != null) {
            guestId = bundle.getInt(Constants.GUEST.ID)
            viewModel.getGuest(guestId)
        }
    }

    private fun observe() {
        viewModel.guest.observe(this, Observer {
            binding.editName.setText(it.name)
            if (it.presence) {
                binding.radioPresent.isChecked = true
            } else {
                binding.radioAbsent.isChecked = true
            }
        })

        viewModel.saveGuest.observe(this, Observer {
            viewModel.saveGuest.observe(this, Observer {
                if (it) {
                    Toast.makeText(applicationContext, "Sucesso", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, "Falha", Toast.LENGTH_SHORT).show()
                }
                finish()
            })
        })
    }



}