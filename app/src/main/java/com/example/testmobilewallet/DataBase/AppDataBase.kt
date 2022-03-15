package com.example.testmobilewallet.DataBase

import com.example.testmobilewallet.DataBase.entities.Category


import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.testmobilewallet.Dao.CategoryDao
import com.example.testmobilewallet.DataBase.entities.Pay
import com.example.testmobilewallet.DataBase.entities.Services

@Database(entities = [Services::class, Category::class, Pay::class ], version = 4, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun CategoryDao(): CategoryDao
}