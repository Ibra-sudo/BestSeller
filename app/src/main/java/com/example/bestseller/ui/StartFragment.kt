package com.example.bestseller.ui

import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.bestseller.MainViewModel
import com.example.bestseller.R
import com.example.bestseller.adapter.ImagesViewPager2Adapter
import com.example.bestseller.databinding.FragmentStartBinding
import me.relex.circleindicator.CircleIndicator3

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding
    private lateinit var indicator: CircleIndicator3
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val adapter = ImagesViewPager2Adapter()

        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager2)

        binding.viewPager2.adapter = adapter
        binding.viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL


        indicator = view.findViewById(R.id.indicator)
        indicator.createIndicators(5,0)
//        indicator.animatePageSelected(2)
        indicator.animate()
//        indicator.setViewPager(viewPager)

        viewModel.pagerArticle.observe(
            viewLifecycleOwner,
            Observer {
                adapter.submitList(it)
            }
        )
        binding.joinStartButton.setOnClickListener {
            findNavController()
                .navigate(StartFragmentDirections.actionStartFragmentToRegisterFragment())
        }

        binding.loginStartButton.setOnClickListener {
            findNavController()
                .navigate(StartFragmentDirections.actionStartFragmentToLoginFragment())
        }
    }

}