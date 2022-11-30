package com.bhati.jettpackroom

import androidx.lifecycle.MutableLiveData
import com.bhati.jettpackroom.room.Employee
import com.bhati.jettpackroom.room.EmployeeDao

class EmpReposatory(val dao: EmployeeDao) {
    val emplist = dao.getAllEmp()

    fun addEmp(employees: Employee) {
        dao.insertAll(employees)
    }

    fun updateEmp(employees: Employee) {
        dao.update(employees)
    }

    fun deleteEmp(employees: Employee) {
        dao.delete(employees)
    }

    fun selectEmp(empId: Int) {
        dao.loadAllByIds(empId)
    }

    fun getEmpByCompanyorEmpname(
        empName: String,
        empCompany: String
    ) {
        dao.findByName(empName, empCompany)
    }
}