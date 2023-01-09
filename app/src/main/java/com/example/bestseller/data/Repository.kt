package com.example.bestseller.data

import com.example.bestseller.R
import com.example.bestseller.data.model.PagerArticle

class Repository {
    fun loadArticle(): List<PagerArticle> {
        return listOf(
            PagerArticle(
                "Welcome to \n BestSeller!",
                "The most exclusive shop with massive discounts on top brands",
                R.drawable.start_background_image
            ),
            PagerArticle(
                "Welcome to \n BestSeller2!",
                "The most exclusive shop with massive discounts on top brands2",
                R.drawable.register_image
            ),
            PagerArticle(
                "Welcome to \n BestSeller3!",
                "The most exclusive shop with massive discounts on top brands3",
                R.drawable.login_background_image
            ),
            PagerArticle(
                "Welcome to \n BestSeller4!",
                "The most exclusive shop with massive discounts on top brands4",
                R.drawable.screenshot_2022_12_09_at_15_20_13
            ),
        )
    }
}