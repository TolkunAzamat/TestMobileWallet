package com.example.testmobilewallet.DataBase.entities

import androidx.room.*

@Entity (foreignKeys = arrayOf(ForeignKey(entity=Category::class,
    parentColumns=arrayOf("idCategory"),
    childColumns=arrayOf("categoryId"))))
data class Services (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idServices") var idServices:Int?,
    @ColumnInfo("serviceName") var serviceName:String?,
    @ColumnInfo(name = "categoryId") var categoryId:Int?,
)
@Entity
data class Category(
    @PrimaryKey(autoGenerate = true) var idCategory: Int?,
    @ColumnInfo(name = "nameCategory") var nameCategory: String?
)
@Entity
data class Pay (
    @PrimaryKey(autoGenerate = true) var idPay: Int?,
    @ColumnInfo(name = "summa") var summa: Int?,

)

