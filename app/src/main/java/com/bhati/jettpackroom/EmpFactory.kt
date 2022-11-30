package com.bhati.jettpackroom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class EmpFactory(val empReposatory: EmpReposatory) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EmpViewModel::class.java)) {
            return EmpViewModel(empReposatory) as T
        }
        throw java.lang.IllegalArgumentException("Uknown Exception...")
    }
}