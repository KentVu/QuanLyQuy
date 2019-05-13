package com.kentvu.quanlyquy

import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withHint

class UiChecker {
    private val context = InstrumentationRegistry.getTargetContext()

    fun checkEventInputShown() {
        onView(withHint(context.getString(R.string.label_event))).check(matches(isDisplayed()))
    }

}
