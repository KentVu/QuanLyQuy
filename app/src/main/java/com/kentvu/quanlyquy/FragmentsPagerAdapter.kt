package com.kentvu.quanlyquy

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter

class FragmentsPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        return ThanhVienFrag()
    }

    override fun getCount(): Int {
        return 1
    }
}