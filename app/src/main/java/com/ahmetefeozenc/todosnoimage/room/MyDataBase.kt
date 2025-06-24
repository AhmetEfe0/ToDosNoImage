package com.ahmetefeozenc.todosnoimage.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ahmetefeozenc.todosnoimage.data.entity.ToDos

@Database(entities = [ToDos::class], version = 1)
abstract class MyDatabase : RoomDatabase() {
    abstract fun getToDosDao() :ToDosDao

}