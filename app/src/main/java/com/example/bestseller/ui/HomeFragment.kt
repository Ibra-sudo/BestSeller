package com.example.bestseller.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.bestseller.MainViewModel
import com.example.bestseller.R
import com.example.bestseller.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        viewModel.currentUser.observe(viewLifecycleOwner){
            if (it == null){
                findNavController()
                    .navigate(HomeFragmentDirections.actionHomeFragmentToStartFragment())
            }
        }

        binding.homeLogoutBtn.setOnClickListener {
            viewModel.logOut()
        }
    }
}