package com.kentvu.quanlyquy

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.*
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.kentvu.quanlyquy.data.ThanhVien
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.pager_fragment.view.*
import kotlinx.android.synthetic.main.thanh_vien_add.*
import kotlinx.android.synthetic.main.thanh_vien_add.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportFragmentManager.beginTransaction().add(R.id.main_container, ThanhVienFrag())
//        supportFragmentManager.beginTransaction().add(R.id.main_container, PagerFragment())
                /*.addToBackStack(null)*/.commit()
        fab.setOnClickListener { view ->
            supportFragmentManager.beginTransaction().replace(R.id.main_container, AddThanhVienFragment())
                    .addToBackStack(null).commit()
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

    override fun onBackPressed() {
        super.onBackPressed()
    }

    companion object {
        private val TAG = "MainActivity"
    }
}

class AddThanhVienFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.thanh_vien_add, container, false)
        view.button.setOnClickListener { button ->
            FirebaseFirestore.getInstance().collection("thanh_vien")
                    .add(makeThanhVien())
                    .addOnSuccessListener {
                        Snackbar.make(button, "DocumentSnapshot written with ID: " + it.getId(), Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show()

                    }
        }
        return view
    }

    private fun makeThanhVien(): ThanhVien {
        return ThanhVien(editText2.text.toString(), editText.text.toString())
    }
}

class PagerFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView")
        val view = inflater.inflate(R.layout.pager_fragment, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated")
        view.pager.adapter = FragmentsPagerAdapter(activity!!.supportFragmentManager)
        view.pager?.adapter?.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        val pager = view?.pager
        if (pager != null) {
            Log.d(TAG, "onResume:currentItem = 1")
            pager.currentItem = 0
//            pager.adapter?.notifyDataSetChanged()

//            pager.adapter.
        }
    }

    companion object {
        private val TAG = "PagerFragment"
    }
}

