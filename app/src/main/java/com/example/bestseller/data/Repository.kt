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
                "Become a member",
                "You must first be invited by an existing member to obtain the secret code. Membership is free, but it's not for everyone",
                R.drawable.register_image
            ),
            PagerArticle(
                "Store Access",
                "Be part of Our VIP-Club. Silver, Gold and Diamond Members can gain full access to our exclusive stores",
                R.drawable.view_pager_store
            ),
            PagerArticle(
                "Designers",
                "3 million products from over 3,000 of your favourite brands with endless offers to snap up",
                R.drawable.view_pager_brands2
            ),
        )
    }
}