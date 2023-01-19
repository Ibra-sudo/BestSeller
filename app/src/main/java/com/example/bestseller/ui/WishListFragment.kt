package com.example.bestseller.ui

import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.bestseller.MainViewModel
import com.example.bestseller.R
import com.example.bestseller.databinding.FragmentWishListBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class WishListFragment: Fragment() {

    private lateinit var binding: FragmentWishListBinding

    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWishListBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        var bottomNavigationView: BottomNavigationView = view?.findViewById(R.id.wish_list_tab_navigation)!!
        replaceFragment(WomenWishListFragment())
        underlineMenuItem(bottomNavigationView.menu.getItem(0))
        binding.wishListTabNavigation.setOnItemSelectedListener {
            removeItemsUnderline(bottomNavigationView)
            underlineMenuItem(it)
            when(it.itemId) {
                R.id.women_home_tabBar -> replaceFragment(WomenWishListFragment())
                R.id.men_home_tabBar -> replaceFragment(MenWishListFragment())
                R.id.kids_home_tabBar -> replaceFragment(KidsWishListFragment())

                else -> {

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.wish_list_tabLayout,fragment)
        fragmentTransaction.commit()
    }

    private fun removeItemsUnderline(bottomNavigationView: BottomNavigationView) {
        for (i in 0..bottomNavigationView.menu.size() -1) {
            val item = bottomNavigationView.menu.getItem(i)
            item.title = item.title.toString()
        }
    }

    private fun underlineMenuItem(item: MenuItem) {
        val content = SpannableString(item.title)
        content.setSpan(UnderlineSpan(), 0, content.length, 0)
        item.title = content
    }
}