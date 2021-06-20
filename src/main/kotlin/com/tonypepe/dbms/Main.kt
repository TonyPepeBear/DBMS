package com.tonypepe.dbms

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch { Database.startDatabase() }
    Database.query("select *")
    Database.query("select name")
    Database.query("select name teacher")
    Database.query("select name point")
}
