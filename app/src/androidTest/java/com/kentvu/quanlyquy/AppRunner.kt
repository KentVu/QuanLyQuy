package com.kentvu.quanlyquy

import android.support.test.rule.ActivityTestRule
import org.junit.Rule

class AppRunner {
    @get:Rule
    val mActivityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java, false, false)

    fun start() {
        mActivityRule.launchActivity(null)
    }

}
