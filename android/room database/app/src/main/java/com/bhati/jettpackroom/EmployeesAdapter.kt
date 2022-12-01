package com.bhati.jettpackroom

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bhati.jettpackroom.databinding.EmployeesBinding
import com.bhati.jettpackroom.room.Employee

class EmployeesAdapter(
    val employeeslist: List<Employee>,
    val onClickListener: (Employee) -> Unit
) :
    RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: EmployeesBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.employees, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.employeeInfo(employeeslist.get(position), onClickListener)

    }

    override fun getItemCount(): Int {
        return employeeslist.size
    }
}
class ViewHolder(val binding: EmployeesBinding) : RecyclerView.ViewHolder(binding.root) {
    fun employeeInfo(employee: Employee, onClick: (Employee) -> Unit) {
        binding.tvEmpName.text = employee.empName
        binding.tvEmpPosition.text = employee.empType
        binding.tvCompanyName.text = employee.empCompany

        binding.rvView.setOnClickListener {
            onClick(employee)
        }
    }

}
