package com.tonypepe.dbms

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch { Database.startDatabase() }
    Database.query("insert 企管一甲 班級活動 2132 0 M 企業管理學系 60 58 曾欽正")
}
