package com.tonypepe.dbms

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch { Database.startDatabase() }
    Database.query("select class name where 企管一甲")
}
