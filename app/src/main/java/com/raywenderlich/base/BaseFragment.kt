package com.raywenderlich.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

typealias Inflate<T> = (LayoutInflater,ViewGroup?,Boolean)-> T
abstract class BaseFragment<VB: ViewBinding>(private val inflate: Inflate<VB>):Fragment(){

    var binding: VB? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null){
            binding = inflate.invoke(inflater,container,false)
        }
        start(inflater, container)
        return binding?.root
    }

    abstract fun start(inflater: LayoutInflater, viewGroup: ViewGroup?)

}