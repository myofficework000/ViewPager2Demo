package com.code4galaxy.viewpagerdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.code4galaxy.viewpagerdemo.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewpagerAdapter: ViewpagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpViewPager()
    }

    private fun setUpViewPager() {
        //create list of fragments
        val listOfFragments = listOf(HomeFragment(), ProfileFragment(), SettingsFragment())

        // initialize adapter
        viewpagerAdapter = ViewpagerAdapter(
            listOfFragments,
            supportFragmentManager,
            lifecycle
        )

        //set the adapter onto viewpager
        binding.viewPager.adapter = viewpagerAdapter

        // attach tabLayout with viewpager and create tabs with text
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "Home"
                1 -> "Profile"
                2 -> "Settings"
                else -> ""
            }
        }.attach()
    }
}