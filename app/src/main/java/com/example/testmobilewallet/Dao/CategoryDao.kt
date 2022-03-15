package com.example.testmobilewallet.Dao

import androidx.room.*
import com.example.testmobilewallet.DataBase.entities.Category
import com.example.testmobilewallet.DataBase.entities.Pay
import com.example.testmobilewallet.DataBase.entities.Services
@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addCategory(vararg category: Category)

    @Query("SELECT * FROM Category")
    fun getAllCategory(): Array<Category>

    @Query("SELECT nameCategory FROM Category")
    fun getNameCategory(): List<String>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addServices(vararg services: Services)

    @Query("SELECT * FROM Services")
    fun getAllServices(): List<Services>

    @Query("SELECT serviceName FROM Services")
    fun getAllServicesname(): List<String>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addPay(vararg pay: Pay)

    @Query("SELECT summa FROM Pay")
    fun getAllPay(): Array<Pay>

}