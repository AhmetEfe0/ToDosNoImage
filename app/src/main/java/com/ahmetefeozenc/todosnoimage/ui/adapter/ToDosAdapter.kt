package com.ahmetefeozenc.todosnoimage.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ahmetefeozenc.todosnoimage.data.entity.ToDos
import com.ahmetefeozenc.todosnoimage.databinding.CardDesignBinding
import com.ahmetefeozenc.todosnoimage.ui.fragment.MainScreenDirections
import com.ahmetefeozenc.todosnoimage.ui.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class ToDosAdapter(var mContex:Context, var toDosList:List<ToDos>,var viewmodel: MainViewModel) :RecyclerView.Adapter<ToDosAdapter.CardDesignHolder>(){

    inner class CardDesignHolder(var binding:CardDesignBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {
        val binding= CardDesignBinding.inflate(LayoutInflater.from(mContex), parent, false)
        return CardDesignHolder(binding)
    }

    override fun getItemCount(): Int {
        return toDosList.size
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {
        val toDo=toDosList.get(position)
        val design =holder.binding


        design.textViewName.text=toDo.name

        design.cardViewToDo.setOnClickListener(){
            val toUpdateScreen = MainScreenDirections.toUpdateScreen(toDo = toDo)
            it.findNavController().navigate(toUpdateScreen)
        }

        design.imageViewDelete.setOnClickListener(){
            Snackbar.make(it,"Do you want to delete ${toDo.name} ?",Snackbar.LENGTH_SHORT)
                .setAction("YES"){
                    viewmodel.delete(toDo.id)
                }.show()
        }

    }
}