package com.kentvu.quanlyquy

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter
import android.util.Log

class FragmentsPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
//        Log.d(TAG, "getItem")
        return ThanhVienFrag()
    }

    override fun getItemPosition(`object`: Any): Int {
//        Log.d(TAG, "getItemPosition")
        // https://stackoverflow.com/a/7287121/1562087
        return super.getItemPosition(`object`)
//        return PagerAdapter.POSITION_NONE
    }

    override fun getCount(): Int {
//        Log.d(TAG, "getCount")
        return 1
    }

    companion object {
        private val TAG = "FragmentsAdapter"
    }
}