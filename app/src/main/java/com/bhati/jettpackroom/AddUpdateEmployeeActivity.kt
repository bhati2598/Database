package com.bhati.jettpackroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bhati.jettpackroom.databinding.ActivityAddUpdateEmployeeBinding
import com.bhati.jettpackroom.room.AppDatabase

class AddUpdateEmployeeActivity : AppCompatActivity() {
    var binding: ActivityAddUpdateEmployeeBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_add_update_employee)
        val dao = AppDatabase.getInstance(this).dao()
        val reposatory = EmpReposatory(dao)
        val factory = EmpFactory(reposatory)
        val modal = ViewModelProvider(this,factory)[EmpViewModel::class.java]
        binding!!.addEmp = modal
        binding!!.lifecycleOwner  = this

    }
}