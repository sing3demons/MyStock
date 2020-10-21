package com.sing3demons.mystock

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import com.sing3demons.mystock.databinding.ActivityHomeBinding
import com.sing3demons.mystock.ui.main.SectionsPagerAdapter

class HomeActivity : AppCompatActivity() {
    private lateinit var sectionsPagerAdapter: SectionsPagerAdapter
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager, lifecycle)

        setupViewPage()
        setupWidget()
        setupTab()

    }

    private fun setupTab() {
        TabLayoutMediator(binding.tabs, binding.viewPager, TabLayoutMediator.TabConfigurationStrategy{
            tab, position ->
        }).attach()
//        binding.tabs.setupWithViewPager(binding.viewPager)
    }

    private fun setupWidget() {
//        val fab: FloatingActionButton = findViewById(R.id.fab)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun setupViewPage() {
        binding.viewPager.apply {
            adapter = sectionsPagerAdapter
        }.also {
            it.setPageTransformer(HorizontalFlipTransformation())
            it.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    if (position == 0){
                        binding.fab.visibility = View.INVISIBLE
                    } else {
                        binding.fab.visibility = View.INVISIBLE
                    }
                }
            })
        }
        //val viewPager: ViewPager = findViewById(R.id.view_pager)
//        viewPager.adapter = sectionsPagerAdapter
    }
}