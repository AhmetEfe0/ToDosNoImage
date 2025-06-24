package com.ahmetefeozenc.todosnoimage.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ahmetefeozenc.todosnoimage.databinding.FragmentSaveScreenBinding
import com.ahmetefeozenc.todosnoimage.ui.viewmodel.SaveViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SaveScreen : Fragment() {

    private lateinit var binding: FragmentSaveScreenBinding
    private lateinit var viewmodel:SaveViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: SaveViewModel by viewModels()
        viewmodel=tempViewModel
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSaveScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSave.setOnClickListener{
            val name= binding.editTextName.text.toString()
            viewmodel.save(name)
        }
    }

}