package com.sing3demons.mystock

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
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


//        val tabs: TabLayout = findViewById(R.id.tabs)
//        tabs.setupWithViewPager(binding.viewPager)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    private fun setupViewPage() {
        binding.viewPager.apply {
            adapter = sectionsPagerAdapter
        }
        //val viewPager: ViewPager = findViewById(R.id.view_pager)
//        viewPager.adapter = sectionsPagerAdapter
    }
}