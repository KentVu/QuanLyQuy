package com.kentvu.quanlyquy

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.kentvu.quanlyquy.data.ThanhVien
import kotlinx.android.synthetic.main.thanh_vien.view.*

class ThanhVienAdapter(options: FirestoreRecyclerOptions<ThanhVien>) : FirestoreRecyclerAdapter<ThanhVien, ThanhVienAdapter.ViewHolder>(options) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int, thanhVien: ThanhVien) {
        holder.bind(thanhVien)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.thanh_vien, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(thanhVien: ThanhVien) {
            view.ten.text = thanhVien.ten
            view.ngay_sinh.text = thanhVien.ngaySinh
        }

        init {
//            view.ten.text
        }
    }
}