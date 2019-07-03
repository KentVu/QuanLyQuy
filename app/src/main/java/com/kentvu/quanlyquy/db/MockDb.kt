package com.kentvu.quanlyquy.db

import com.kentvu.quanlyquy.business.Db

class MockDb : Db {
    override var events: List<String> = listOf()

}