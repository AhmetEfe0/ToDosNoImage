package com.ahmetefeozenc.todosnoimage.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ahmetefeozenc.todosnoimage.data.entity.ToDos
import com.ahmetefeozenc.todosnoimage.data.repo.ToDosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(var toDosRepository : ToDosRepository) : ViewModel() {
    var toDosList = MutableLiveData<List<ToDos>>()

    init {
        loadToDos()
    }

    fun delete(id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            toDosRepository.delete(id)
            loadToDos()
        }
    }
    fun loadToDos() {
        CoroutineScope(Dispatchers.Main).launch {
            toDosList.value = toDosRepository.loadToDos() //Tetikleme veya veri aktarımı
        }
    }
    fun search(searchText:String){
        CoroutineScope(Dispatchers.Main).launch {
            toDosList.value=toDosRepository.search(searchText)
        }
    }
}