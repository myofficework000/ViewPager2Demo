package com.code4galaxy.viewpagerdemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.code4galaxy.viewpagerdemo.databinding.ActivityCustomTabBinding
import com.code4galaxy.viewpagerdemo.databinding.ActivityMainBinding
import com.code4galaxy.viewpagerdemo.databinding.CustomTabBinding
import com.google.android.material.tabs.TabLayoutMediator

class CustomTabActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCustomTabBinding
    private lateinit var viewpagerAdapter: ViewpagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomTabBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpCustomTabViewPager()
    }

    private fun setUpCustomTabViewPager() {
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

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            val customTabBinding = CustomTabBinding.inflate(layoutInflater)

            when (position) {
                0 -> {
                    customTabBinding.tabIcon.setImageResource(R.drawable.baseline_home_24)
                    customTabBinding.tabText.text = "Home"
                }
                1 -> {
                    customTabBinding.tabIcon.setImageResource(R.drawable.baseline_person_24)
                    customTabBinding.tabText.text = "Profile"
                }
                2 -> {
                    customTabBinding.tabIcon.setImageResource(R.drawable.baseline_settings_24)
                    customTabBinding.tabText.text = "Settings"
                }
            }

            tab.customView = customTabBinding.root
        }.attach()
    }
}