package com.example.getnews.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.getnews.R
import com.example.recyclervieww.Person
import com.example.recyclervieww.RecyclerViewPoster


class NewsFragment : Fragment(R.layout.fragment_news) {
    private lateinit var recyclerView: RecyclerView
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = RecyclerViewPoster(getPersonData())

    }

    private fun getPersonData() : List<Person> {
        val posterList = ArrayList<Person>()

        posterList.add(
            Person(
                1,
                "https://www.technical-support-email.com/wp-content/uploads/2021/12/Android.jpg",
                "Android",
                "Warningead",
            )
        )

        posterList.add(
            Person(
                2,
                "https://cdn.vox-cdn.com/thumbor/BDzAKVS2KqaNL9-NbUt0cxJvP-o=/0x0:1358x817/1200x800/filters:focal(571x301:787x517)/cdn.vox-cdn.com/uploads/chorus_image/image/70413203/twitter_nft_hex.0.jpg",
                "NFT",
                "The Future?",
            )
        )
        posterList.add(
            Person(
                3,
                "https://images.unsplash.com/photo-1614727187346-ec3a009092b0?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1000&q=80",
                "NASA",
                "Water on Mars?",
            )
        )
        posterList.add(
            Person(
                4,
                "https://bs-uploads.toptal.io/blackfish-uploads/components/seo/content/og_image_file/og_image/777062/ethereum-solidity-oracle-contracts-pt2-cd3dbde2a52e64e709b7244efaf925b1.png",
                "Solidity",
                "Learn easily",
            )
        )
        posterList.add(
            Person(
                5,
                "https://beincrypto.com/wp-content/uploads/2022/01/github.png",
                "Linus Torvalds",
                "I am Satoshi",
            )
        )
        posterList.add(
            Person(
                6,
                "https://github.blog/wp-content/uploads/2021/12/GitHub-code-search_banner.png?fit=1200%2C630",
                "GitHub",
                "Is GitHub Safe?",
            )
        )
        return posterList
    }
}