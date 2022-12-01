package com.bhati.jettpackroom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bhati.jettpackroom.databinding.ActivityEmployeesBinding
import com.bhati.jettpackroom.room.AppDatabase
import com.bhati.jettpackroom.room.Employee

class EmployeesActivity : AppCompatActivity() {
    var binding: ActivityEmployeesBinding? = null
    var empId: Int? = null
    var employeeList: ArrayList<Employee>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employees)

        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_employees)
        val dao = AppDatabase.getInstance(this).dao()
        val reposatory = EmpReposatory(dao)
        val factory = EmpFactory(reposatory)
        val viewModal = ViewModelProvider(this, factory)[EmpViewModel::class.java]
        binding!!.mainViewModel = viewModal
        binding!!.lifecycleOwner = this

        binding!!.btnUpdateEmp.setOnClickListener {
            if (empId == null) {
                startActivity(
                    Intent(this, AddUpdateEmployeeActivity::class.java)
                        .putExtra("empId", 0)
                )
            } else {
                startActivity(
                    Intent(this, AddUpdateEmployeeActivity::class.java)
                        .putExtra("empId", empId)
                )
            }

        }
        getEmpData(viewModal)


    }

    private fun getEmpData(viewModal: EmpViewModel) {
        binding!!.rvEmployees.layoutManager = LinearLayoutManager(this)

        viewModal.employees.observe(this, Observer {
            binding!!.rvEmployees.adapter = EmployeesAdapter(it) { selectedItem: Employee ->
                onItemClieck(selectedItem)
            }
        })

    }

    private fun onItemClieck(selectedItem: Employee) {
        empId = selectedItem.empId
    }


}