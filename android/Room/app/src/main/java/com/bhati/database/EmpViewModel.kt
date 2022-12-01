package com.bhati.jettpackroom

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bhati.jettpackroom.room.Employee

class EmpViewModel(private val empReposatory: EmpReposatory) : ViewModel() {
    var empName = MutableLiveData<String>()
    var empPosition = MutableLiveData<String>()
    var empCompany = MutableLiveData<String>()
    var empId: Int = 0
    val employees = empReposatory.emplist

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
                            0, empName.toString(), empPosition.toString(), empCompany.toString()
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

    fun searchbyNameorCompany() {
        when {
            empName.value.isNullOrEmpty() -> {
                Log.e("inserError...", "Enter employee name...")
            }
            empCompany.value.isNullOrEmpty() -> {
                Log.e("inserError...", "Enter employee company...")
            }
            else -> {
                empReposatory.getEmpByCompanyorEmpname(
                    empName.value.toString(),
                    empCompany.value.toString()
                )
            }
        }
    }

    fun searchUserById(empId: Int) {
        empReposatory.selectEmp(empId)
    }


}