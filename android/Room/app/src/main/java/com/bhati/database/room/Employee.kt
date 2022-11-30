package com.bhati.jettpackroom.room

import androidx.lifecycle.MutableLiveData
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Employees")
data class Employee(
    @PrimaryKey val empId: Int,
    @ColumnInfo(name = "emp_name") val empName: String,
    @ColumnInfo(name = "emp_type") val empType: String,
    @ColumnInfo(name = "emp_company") val empCompany: String,
)