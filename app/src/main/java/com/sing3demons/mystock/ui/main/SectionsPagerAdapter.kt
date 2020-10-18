package com.sing3demons.mystock.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

//private val TAB_TITLES = arrayOf(
//    R.string.tab_text_1,
//    R.string.tab_text_2
//)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount() = 2

    override fun createFragment(position: Int): Fragment {
        return PlaceholderFragment.newInstance(position + 1)
    }

//    override fun getItem(position: Int): Fragment {
//        // getItem is called to instantiate the fragment for the given page.
//        // Return a PlaceholderFragment (defined as a static inner class below).
//        return PlaceholderFragment.newInstance(position + 1)
//    }
//
//    override fun getPageTitle(position: Int): CharSequence? {
//        return context.resources.getString(TAB_TITLES[position])
//    }
//
//    override fun getCount(): Int {
//        // Show 2 total pages.
//        return 2
//    }


}