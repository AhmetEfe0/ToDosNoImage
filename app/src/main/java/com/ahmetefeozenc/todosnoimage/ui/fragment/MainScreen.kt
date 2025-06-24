package com.ahmetefeozenc.todosnoimage.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.ahmetefeozenc.todosnoimage.R
import com.ahmetefeozenc.todosnoimage.databinding.FragmentMainScreenBinding
import com.google.android.material.snackbar.Snackbar
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ahmetefeozenc.todosnoimage.data.entity.ToDos
import com.ahmetefeozenc.todosnoimage.ui.adapter.ToDosAdapter
import com.ahmetefeozenc.todosnoimage.ui.viewmodel.MainViewModel
import com.ahmetefeozenc.todosnoimage.ui.viewmodel.UpdateViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainScreen : Fragment() {

    private lateinit var binding: FragmentMainScreenBinding
    private lateinit var viewmodel:MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentMainScreenBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MainViewModel by viewModels()
        viewmodel=tempViewModel
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewmodel.toDosList.observe(viewLifecycleOwner, ){
            val toDosAdapter =ToDosAdapter(requireContext(),it,viewmodel)
            binding.recyclerViewToDos.adapter =toDosAdapter
        }

        binding.recyclerViewToDos.layoutManager=LinearLayoutManager(requireContext())
        //binding.recyclerViewToDos.layoutManager=StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)

        binding.searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                viewmodel.search(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                viewmodel.search(query)
                return true
            }
        })

        binding.fab.setOnClickListener {
            it.findNavController().navigate(R.id.toSaveScreen)

        }
    }

    override fun onResume() {
        super.onResume()
        viewmodel.loadToDos()
    }
}