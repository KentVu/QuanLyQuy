package com.kentvu.quanlyquy

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.google.firebase.firestore.QuerySnapshot
import com.kentvu.quanlyquy.data.ThanhVien
import kotlinx.android.synthetic.main.thanh_vien.view.*

class ThanhVienAdapter(val result: QuerySnapshot) : RecyclerView.Adapter<ThanhVienAdapter.ViewHolder>() {
    init {
        result.map { document -> ThanhVien(document) }
    }
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder.bind()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            view.ten.text
        }
    }
}