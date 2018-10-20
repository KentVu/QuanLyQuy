package com.kentvu.quanlyquy.data

import com.google.firebase.firestore.QueryDocumentSnapshot

class ThanhVien(document: QueryDocumentSnapshot) {
    init {
        document.data.get()
    }
}
