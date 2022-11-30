package com.bhati.jettpackroom

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bhati.jettpackroom.room.Employee

class EmpViewModel(private val empReposatory: EmpReposatory) : ViewModel() {
    val empName: MutableLiveData<String>? = null
    val empPosition: MutableLiveData<String>? = null
    val empCompany: MutableLiveData<String>? = null
    val empId: Int? = null

    fun AddUpdateClick() {
        when {
            empName!!.value.toString().isNullOrEmpty() -> {
                Log.e("inserError...", "Enter employee name...")

            }
            empPosition!!.value.toString().isNullOrEmpty() -> {
                Log.e("inserError...", "Enter employee position...")

            }
            empCompany!!.value.toString().isNullOrEmpty() -> {
                Log.e("inserError...", "Enter employee company...")

            }
            else -> {
                while (empId == null) {
                    empReposatory.addEmp(Employee(0, empName, empPosition, empCompany))
                }
                empReposatory.updateEmp(Employee(empId, empName, empPosition, empCompany))
            }
        }
    }


    val employees = empReposatory.emplist

}