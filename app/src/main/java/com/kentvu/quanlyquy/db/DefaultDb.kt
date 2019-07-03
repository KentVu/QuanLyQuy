package com.kentvu.quanlyquy.db

import com.kentvu.quanlyquy.business.Db

class DefaultDb : Db {
    override var events: List<String> = listOf()
}