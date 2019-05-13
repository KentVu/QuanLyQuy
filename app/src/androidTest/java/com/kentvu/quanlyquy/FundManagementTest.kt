package com.kentvu.quanlyquy

import android.support.test.InstrumentationRegistry
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

    private val app = App.get(InstrumentationRegistry.getTargetContext())

    @Test
    fun autoCompleteOnTypingEvent() {
        showEventInputWhenStartup()
//        val events = emptyList<String>()
        val summerEvents = listOf("Summer Vacation", "Summer BBQ")
        app.testSupport {
            db = mockDb {
                this.events = summerEvents
            }
        }
        typingRobot {
            type("S")
        } check {
            autoCompleteListDisplayed(summerEvents)
        }
    }

    private fun mockDb(function: Db.() -> Unit): Db? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun typingRobot(function: TypingRobot.() -> Unit): TypingRobot {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class TypingRobot {
    internal fun type(s: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
