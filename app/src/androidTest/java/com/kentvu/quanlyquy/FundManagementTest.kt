package com.kentvu.quanlyquy

import androidx.test.InstrumentationRegistry
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.runner.AndroidJUnit4
import com.kentvu.quanlyquy.business.Db
import com.kentvu.quanlyquy.db.MockDb
import org.hamcrest.Matchers.isOneOf
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
        val mockDb = MockDb()
        function(mockDb)
        return mockDb
    }

    private fun typingRobot(function: TypingRobot.() -> Unit): TypingRobot {
        val typingRobot = TypingRobot()
        function(typingRobot)
        return typingRobot
    }
}

class TypingRobot {
    internal fun type(s: String) {
        typeText(s)
    }

    infix fun check(checkBlock: CheckingRobot.() -> Unit) {
        checkBlock(CheckingRobot())
    }
}

class CheckingRobot {
    fun autoCompleteListDisplayed(list: List<String>) {
        //Espresso.onView(withId(R.id.event))
        onData(isOneOf(list.toTypedArray())).check(matches(isDisplayed()))
    }

}
