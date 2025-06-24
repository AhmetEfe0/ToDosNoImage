package com.ahmetefeozenc.todosnoimage.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.ahmetefeozenc.todosnoimage.data.repo.ToDosRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UpdateViewModel @Inject constructor(var toDosRepository : ToDosRepository) : ViewModel() {

    fun update(id:Int,name:String){
        CoroutineScope(Dispatchers.Main).launch {
            toDosRepository.update(id,name)
        }
    }
}