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
import com.example.bestseller.databinding.FragmentNavBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class NavFragment: Fragment() {

    private lateinit var binding: FragmentNavBinding

    private val viewModel: MainViewModel by activityViewModels()

//    private lateinit var navView: BottomNavigationView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNavBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        replaceFragment(HomeFragment())

//        var navView: BottomNavigationView = view.findViewById(R.id.nav_home)
//        navView.itemIconTintList = null


        viewModel.currentUser.observe(viewLifecycleOwner){
            if (it == null){
                findNavController()
                    .navigate(NavFragmentDirections.actionHomeFragmentToStartFragment())
            }
        }

        binding.homeLogoutBtn.setOnClickListener {
            viewModel.logOut()
        }

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.nav_home -> replaceFragment(HomeFragment())
                R.id.nav_categories -> replaceFragment(CategoriesFragment())
                R.id.nav_wish_list -> replaceFragment(WishListFragment())
                R.id.nav_card -> replaceFragment(CardFragment())
                R.id.nav_account -> replaceFragment(AccountFragment())

                else -> {

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.home_frameLayout,fragment)
        fragmentTransaction.commit()
    }
}