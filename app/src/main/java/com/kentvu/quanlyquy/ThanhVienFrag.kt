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

class ThanhVienFrag: Fragment() {
    lateinit var adapter: ThanhVienAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.thanh_vien_list, container, false)

        // Access a Cloud Firestore instance from your Activity
        val db = FirebaseFirestore.getInstance()
        val query = db.collection("thanh_vien")
        val options = FirestoreRecyclerOptions.Builder<ThanhVien>().setQuery(query, ThanhVien::class.java)
                .build()
        adapter = ThanhVienAdapter(options)
        view.thanh_vien_grid.adapter = adapter
        adapter.startListening()
        return view
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        adapter.stopListening()
    }

    companion object {
        private val TAG = "ThanhVienFrag"
    }
}