package com.kentvu.quanlyquy

import android.support.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FundManagementTest {
    private val appRunner = AppRunner()

    private val uiChecker = UiChecker()

    @Test
    fun showEventInputWhenStartup() {
        appRunner.start()
        uiChecker.checkEventInputShown()
    }

}
