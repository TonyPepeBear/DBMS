package com.tonypepe.dbms

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch { Database.startDatabase() }
    Database.query("delete 企管一甲")
}
