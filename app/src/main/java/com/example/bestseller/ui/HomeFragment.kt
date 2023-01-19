package com.example.bestseller.ui

import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.*
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.bestseller.MainViewModel
import com.example.bestseller.R
import com.example.bestseller.adapter.TabViewPagerAdapter
import com.example.bestseller.databinding.FragmentHomeBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout.TabView

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
        var bottomNavigationView: BottomNavigationView = view?.findViewById(R.id.home_tab_navigation)!!
        replaceFragment(WomenFragment())
        underlineMenuItem(bottomNavigationView.menu.getItem(0))

        binding.homeTabNavigation.setOnItemSelectedListener {
            removeItemsUnderline(bottomNavigationView)
            underlineMenuItem(it)
            when(it.itemId) {
                R.id.women_home_tabBar -> replaceFragment(WomenFragment())
                R.id.men_home_tabBar -> replaceFragment(MenFragment())
                R.id.kids_home_tabBar -> replaceFragment(KidsFragment())

                else -> {

                }
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.home_tabLayout,fragment)
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



