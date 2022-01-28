package com.example.getnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.getnews.authFragments.Login
import com.example.getnews.authFragments.Register
import com.example.getnews.fragments.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        var tabLayout = findViewById<TabLayout>(R.id.fragmentTabs)
        var viewPager2 = findViewById<ViewPager2>(R.id.fragmentViewer)

        var list = ArrayList<Fragment>()


        var login = Login()
        var register = Register()


        list.add(login)
        list.add(register)
        var viewPagerAdapter = ViewPager(this , list)

        viewPager2.adapter = viewPagerAdapter

        TabLayoutMediator(tabLayout, viewPager2) {
            tab,position->   if(position==0){
                tab.text="სისტემაში შესვლა"
            }
            if(position==1){
                tab.text="რეგისტრაცია"
            }
        }.attach()


    }
}