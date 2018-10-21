package com.kentvu.quanlyquy.data

import com.google.firebase.firestore.QueryDocumentSnapshot

class ThanhVien() {
    constructor(ten: String, birth: String) : this() {
        this.ten = ten
        this.ngaySinh = birth
    }

    init {
    }

    var ten = ""
    var ngaySinh = ""
    override fun toString(): String {
        return super.toString()
    }
}
