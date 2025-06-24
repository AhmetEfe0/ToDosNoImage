package com.ahmetefeozenc.todosnoimage.data.repo

import com.ahmetefeozenc.todosnoimage.data.datasource.ToDosDataSource
import com.ahmetefeozenc.todosnoimage.data.entity.ToDos

class ToDosRepository (var toDosDataSource:ToDosDataSource) {


    suspend fun save(name:String) = toDosDataSource.save(name)

    suspend fun update(id:Int,name:String) = toDosDataSource.update(id, name)

    suspend fun delete(id:Int) = toDosDataSource.delete(id)

    suspend fun loadToDos() : List<ToDos> =toDosDataSource.loadToDos()

    suspend fun search(searchText:String): List<ToDos> =toDosDataSource.search(searchText)
}