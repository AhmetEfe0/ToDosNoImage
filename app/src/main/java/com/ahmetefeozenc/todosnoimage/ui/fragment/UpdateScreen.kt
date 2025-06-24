package com.ahmetefeozenc.todosnoimage.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ahmetefeozenc.todosnoimage.databinding.FragmentUpdateScreenBinding
import com.ahmetefeozenc.todosnoimage.ui.viewmodel.UpdateViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateScreen : Fragment() {

    private lateinit var binding: FragmentUpdateScreenBinding
    private lateinit var viewmodel: UpdateViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:UpdateViewModel by viewModels()
        viewmodel=tempViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentUpdateScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle:UpdateScreenArgs by navArgs()
        val toDo=bundle.toDo

        binding.editTextName.setText(toDo.name)
        binding.buttonUpdateScreenSave.setOnClickListener{
            val name = binding.editTextName.text.toString()
            viewmodel.update(toDo.id,name)
        }
    }

}