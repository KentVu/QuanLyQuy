package com.kentvu.quanlyquy.business

import android.util.Log
import com.kentvu.quanlyquy.MyLog
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainFlow() {
    lateinit var gui: Gui
    fun onCreate(gui: Gui) {
        Log.d(TAG, "onCreate")
        this.gui = gui
        GlobalScope.launch(Dispatchers.Main) {for (e in gui.eventSource) {
            log.d("${e.type}:${e.data}")}}
    }

    companion object {
        const val TAG = "MainFlow"
        val log = MyLog(TAG)
    }
}
