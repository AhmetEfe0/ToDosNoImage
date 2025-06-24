package com.ahmetefeozenc.todosnoimage.data.datasource

import android.util.Log
import com.ahmetefeozenc.todosnoimage.data.entity.ToDos
import com.ahmetefeozenc.todosnoimage.room.ToDosDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDosDataSource(var toDosDao: ToDosDao) {
    suspend fun save(name:String){
        val newToDo=ToDos(0,name)
        toDosDao.save(newToDo)
    }
    suspend fun update(id:Int,name:String){
        toDosDao.update(id,name)
    }
    suspend fun delete(id:Int){
        toDosDao.delete(id)
    }
    suspend fun loadToDos() : List<ToDos> = withContext(Dispatchers.IO){
        return@withContext toDosDao.loadToDos()
    }
    suspend fun search(searchText:String): List<ToDos> = withContext(Dispatchers.IO){
        return@withContext toDosDao.search((searchText))
    }

}