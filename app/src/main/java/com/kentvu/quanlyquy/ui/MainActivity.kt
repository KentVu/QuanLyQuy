package com.kentvu.quanlyquy.ui

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.kentvu.quanlyquy.App
import com.kentvu.quanlyquy.R
import com.kentvu.quanlyquy.business.MainFlow
import com.kentvu.quanlyquy.business.Event
import com.kentvu.quanlyquy.business.EventType
import com.kentvu.quanlyquy.business.Gui

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.launch

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity(), TextView.OnEditorActionListener, Gui {
    private val eventChannel = Channel<Event>()
    override val eventSource: ReceiveChannel<Event>
        get() = eventChannel
    private lateinit var mainFlow: MainFlow

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        event.setOnEditorActionListener(this)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        mainFlow = (applicationContext as App).mainFlow
        mainFlow.onCreate(this as Gui)
    }

    override fun onEditorAction(p0: TextView?, p1: Int, p2: KeyEvent?): Boolean {
        // lookup event
        val evtName = event.text.toString()
        GlobalScope.launch { eventChannel.send(Event(EventType.EventTyped, evtName)) }
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
