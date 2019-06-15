package com.kentvu.quanlyquy

import android.app.Application
import android.content.Context
import kotlin.reflect.KProperty

class App: Application() {
    fun testSupport(function: TestSupport.() -> Unit) = TestSupport().apply(function)
    var db: Db = DefaultDb()

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

class DefaultDb : Db {
    override var events: List<String> = listOf()

}

interface Db {
    var events: List<String>
    //fun exists(name: String)
}
