package com.kentvu.quanlyquy

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.firestore.FirebaseFirestore
import com.kentvu.quanlyquy.data.ThanhVien
import kotlinx.android.synthetic.main.thanh_vien_list.view.*

class ThanhVienFrag : Fragment() {
    lateinit var adapter: ThanhVienAdapter

    init {
        Log.d(TAG, "new ThanhVienFrag")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView")
        val view = inflater.inflate(R.layout.thanh_vien_list, container, false)

        // Access a Cloud Firestore instance from your Activity
        val db = FirebaseFirestore.getInstance()
        val query = db.collection("thanh_vien")
        val options = FirestoreRecyclerOptions.Builder<ThanhVien>().setQuery(query, ThanhVien::class.java)
                .build()
        adapter = ThanhVienAdapter(options)
        return view
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart")
//        update()
    }

    private fun update() {
        adapter.startListening()
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
        view?.thanh_vien_grid?.adapter = adapter
        update()
//        adapter.startListening()
    }

    override fun onPause() {
        super.onPause()
//        adapter.stopListening()
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop")
        adapter.stopListening()
    }

    override fun onDestroyView() {
        super.onDestroyView()
//        adapter.stopListening()
    }

    companion object {
        private val TAG = "ThanhVienFrag"
    }
}