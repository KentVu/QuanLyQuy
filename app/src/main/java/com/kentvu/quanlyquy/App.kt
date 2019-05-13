package com.kentvu.quanlyquy

import android.app.Application
import android.content.Context

class App: Application() {
    fun testSupport(function: TestSupport.() -> Unit) = TestSupport().apply(function)
    var db: Db? = null
        private set

    inner class TestSupport {
        var db: Db? = null
            set(value) { this@App.db = value }
    }

    companion object {
        fun get(ctx: Context) = ctx.applicationContext as App
    }
}

interface Db {
    var events: List<String>
}
