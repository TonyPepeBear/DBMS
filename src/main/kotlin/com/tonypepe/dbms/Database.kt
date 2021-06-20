package com.tonypepe.dbms

import java.io.File

object DBMS {
    private var selectedDatabase = ""

    fun initDBMS() {
        val db = File("./db")
        if (!db.exists()) {
            db.mkdir()
        }
    }

    fun query(q: String) {
        val split = q.split(" ")
        when (split[0].uppercase()) {
            "CREATE" -> {
                create(split)
            }
            else -> {
                throw QueryError()
            }
        }
    }

    private fun create(split: List<String>) {
        val message: String = when (split[1].uppercase()) {
            "DATABASE" -> {
                createDatabase(split)
            }
            "TABLE" -> {
                createTable(split)
            }
            else -> {
                throw QueryError()
            }
        }
    }

    private fun createDatabase(split: List<String>): String {
        if (split.size > 3) {
            throw QueryError()
        }
        val dbName = split[2]
        val db = File("./db/$dbName")
        if (!db.exists()) {
            db.mkdir()
            return ""
        }
        return "Database $dbName is already exist!!"
    }

    private fun createTable(split: List<String>): String {
        TODO()
    }

    private fun getDatabases(): List<String> {
        val fileList = File("./db").listFiles() ?: return emptyList()
        return fileList.filter { it.isDirectory }.map { it.name }
    }

    fun selectDB(s: String): String {
        val db = File("./db").listFiles()
        if (getDatabases().contains(s)) throw QueryError("No such database")
        selectedDatabase = s
        return ""
    }
}
