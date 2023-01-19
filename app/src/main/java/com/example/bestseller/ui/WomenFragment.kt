package com.example.bestseller.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.bestseller.MainViewModel
import com.example.bestseller.databinding.FragmentHomeWomenTablayoutBinding

class WomenFragment: Fragment() {

    private lateinit var binding: FragmentHomeWomenTablayoutBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeWomenTablayoutBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //TODO
    }
}