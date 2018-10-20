package com.kentvu.quanlyquy

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // Access a Cloud Firestore instance from your Activity
        val db = FirebaseFirestore.getInstance()
        // Create a new user with a first, middle, and last name
//        val user = mapOf<String, Any>(
//                "ten" to "Vu Tran Kien",
//                "ngay_sinh" to "1991/01/01"
//        )
//        db.collection("thanh_vien")
//                .add(user)
//                .addOnSuccessListener {documentReference ->  Log.d(TAG, "DocumentSnapshot added with ID: "
//                        + documentReference.getId()) }
//                .addOnFailureListener {e -> Log.w(TAG, "Error adding document", e)}
        db.collection("thanh_vien").get()
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        val result = task.result
                        if (result != null) {
                            result.forEach { document -> Log.d(TAG, document.id + " => " + document.data) }
                            thanh_vien_grid.adapter = ThanhVienAdapter(result)
                        }
                    }
                    else Log.w(TAG, "Error getting documents.", task.exception)
                }
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
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

    companion object {
        private val TAG = "MainActivity"
    }
}

