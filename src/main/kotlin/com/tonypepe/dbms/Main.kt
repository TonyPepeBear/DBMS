package com.tonypepe.dbms

import java.io.File

fun main() {
    File("./db").mkdir()
    File("./db/abc").mkdir();
    File("./db/123").mkdir();
    File("./db/xyz").mkdir();
    File("./db/xyz/abc").mkdir();
    File("./db/").list()?.forEach {
        println(it)
    }
}
