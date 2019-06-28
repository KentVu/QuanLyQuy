package com.kentvu.quanlyquy

import androidx.test.InstrumentationRegistry
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withHint

class UiChecker {
    private val context = InstrumentationRegistry.getTargetContext()

    fun checkEventInputShown() {
        onView(withHint(context.getString(R.string.label_event))).check(matches(isDisplayed()))
    }

}
