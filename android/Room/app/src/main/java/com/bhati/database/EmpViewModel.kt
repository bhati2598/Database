package com.bhati.jettpackroom

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bhati.jettpackroom.room.Employee

class EmpViewModel(private val empReposatory: EmpReposatory) : ViewModel() {
    val empName = MutableLiveData<String>()
    val empPosition = MutableLiveData<String>()
    val empCompany = MutableLiveData<String>()
    val empId : Int= 0

    fun AddUpdateClick() {
        when {
            empName.value.isNullOrEmpty() -> {
                Log.e("inserError...", "Enter employee name...")

            }
            empPosition.value.isNullOrEmpty() -> {
                Log.e("inserError...", "Enter employee position...")

            }
            empCompany.value.isNullOrEmpty() -> {
                Log.e("inserError...", "Enter employee company...")

            }
            else -> {
                while (empId == 0) {
                    empReposatory.addEmp(
                        Employee(
                            0,
                            empName.toString(),
                            empPosition.toString(),
                            empCompany.toString()
                        )
                    )
                }
                empReposatory.updateEmp(
                    Employee(
                        empId,
                        empName.toString(),
                        empPosition.toString(),
                        empCompany.toString()
                    )
                )
            }
        }
    }


    val employees = empReposatory.emplist

}