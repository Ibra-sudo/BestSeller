package com.example.bestseller.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.bestseller.ui.HomeFragment

class TabViewPagerAdapter(supportFragmentManager: FragmentManager) : FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var fragmentArrayList: ArrayList<Fragment> = ArrayList()
    private var fragmentTitle: ArrayList<String> = ArrayList()

    override fun getItem(position: Int): Fragment {

        return fragmentArrayList[position]
    }

    override fun getCount(): Int {
        return fragmentArrayList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitle[position]
    }

    fun addFragment(fragment: Fragment, title: String){
        fragmentArrayList.add(fragment)
        fragmentTitle.add(title)
    }

}