package com.bhati.jettpackroom

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bhati.jettpackroom.room.Employee

class EmpViewModel(private val empReposatory: EmpReposatory) : ViewModel() {
    val empName = MutableLiveData<String>()
    val empPosition = MutableLiveData<String>()
    val empCompany = MutableLiveData<String>()
    val empId: Int? = null

    fun AddUpdateClick() {
        when {
            empName.value.toString().isNotEmpty() -> {
                Log.e("inserError...", "Enter employee name...")

            }
            empPosition!!.value.toString().isNotEmpty() -> {
                Log.e("inserError...", "Enter employee position...")

            }
            empCompany!!.value.toString().isNotEmpty() -> {
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