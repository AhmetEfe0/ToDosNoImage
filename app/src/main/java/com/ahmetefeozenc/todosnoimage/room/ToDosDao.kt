package com.ahmetefeozenc.todosnoimage.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ahmetefeozenc.todosnoimage.data.entity.ToDos

@Dao
interface ToDosDao {//Dao Database Access Object
    @Query("SELECT * FROM toDos")
    suspend fun  loadToDos():List<ToDos>

    @Insert
    suspend fun save(toDO:ToDos)

    @Query("UPDATE toDos Set name = :name  WHERE id= :id")
    suspend fun update(id:Int,name:String)

    @Query("DELETE FROM toDos WHERE id = :id")
    suspend fun delete(id:Int)

    @Query("SELECT * FROM toDos WHERE name LIKE '%' || :searchText || '%'")
    suspend fun search(searchText:String):List<ToDos>
}