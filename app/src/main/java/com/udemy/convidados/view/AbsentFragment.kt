package com.udemy.convidados.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.udemy.convidados.constants.Constants
import com.udemy.convidados.databinding.FragmentAbsentBinding
import com.udemy.convidados.view.adapter.GuestsAdapter
import com.udemy.convidados.view.listener.OnGuestListener
import com.udemy.convidados.viewModel.GuestsViewModel

class AbsentFragment : Fragment() {

    private var _binding: FragmentAbsentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: GuestsViewModel
    private val adapter = GuestsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(GuestsViewModel::class.java)
        _binding = FragmentAbsentBinding.inflate(inflater, container, false)

        //Layout
        binding.recyclerAbsent.layoutManager = LinearLayoutManager(context)
        //adapter
        binding.recyclerAbsent.adapter = adapter

        val listener = object : OnGuestListener {
            override fun onClick(id: Int) {
                val bundle = Bundle()
                bundle.putInt(Constants.GUEST.ID, id)

                startActivity(Intent(context, GuestFormActivity::class.java).putExtras(bundle))
            }

            override fun onDelete(id: Int) {
                viewModel.delete(id)
                viewModel.getAbsent()
            }
        }

        adapter.attachListener(listener)
        observe()

        return binding.root
    }

    /**
     * Ciclo de vida - onResume
     */
    override fun onResume() {
        super.onResume()
        viewModel.getAbsent()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observe() {
        viewModel.guestList.observe(viewLifecycleOwner) {
            adapter.updateGuests(it)
        }
    }


}