package com.kentvu.quanlyquy

import android.app.Application
import android.content.Context
import com.kentvu.quanlyquy.business.Db
import com.kentvu.quanlyquy.business.MainFlow
import com.kentvu.quanlyquy.db.DefaultDb

class App: Application() {
    fun testSupport(function: TestSupport.() -> Unit) = TestSupport().apply(function)
    var db: Db = DefaultDb()
    val mainFlow = MainFlow()

    inner class TestSupport {
        var db: Db? = null
            set(value) { this@App.db = value!! }
    }

    companion object {
        operator fun get(ctx: Context): App {
            return ctx.applicationContext as App
        }
    }
}

