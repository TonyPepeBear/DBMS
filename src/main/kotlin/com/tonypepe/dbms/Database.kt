package com.tonypepe.dbms

import com.opencsv.CSVReader
import kotlinx.coroutines.channels.Channel

object Database {
    private fun getNewCSVReader(): CSVReader = CSVReader("db.csv".toFile().reader())
    private val queryQueue = Channel<String>()

    suspend fun startDatabase() {
        for (receive in queryQueue) {
            println(startQuery(receive))
        }
    }

    suspend fun query(q: String) {
        queryQueue.send(q)
    }

    private fun startQuery(q: String): String {
        return when (q.split(" ")[0].uppercase()) {
            "SELECT" -> {
                select(q)
            }
            "DELETE" -> {
                TODO()
            }
            "INSERT" -> {
                TODO()
            }
            else -> {
                throw QueryError()
            }
        }
    }

    private fun select(q: String): String {
        val split = q.split(" ")
        val selColumn = arrayListOf<Boolean>().apply { repeat(9) { add(false) } }
        if (split[1] == "*") {
            if (split.size > 2) throw QueryError()
            for (i in selColumn.indices) {
                selColumn[i] = true
            }
        } else {
            for (i in 1 until split.size) {
                val inx = when (split[i]) {
                    "class" -> 0
                    "name" -> 1
                    "id" -> 2
                    "point" -> 3
                    "main" -> 4
                    "dep" -> 5
                    "count" -> 6
                    "picked" -> 7
                    "teacher" -> 8
                    else -> throw QueryError("No Such column: ${split[i]}")
                }
                selColumn[inx] = true
            }
        }
        val result = selectFromFile(selColumn)
        return select2String(result)
    }

    private fun selectFromFile(selColumn: ArrayList<Boolean>): List<List<String>> {
        val result = arrayListOf<List<String>>()
        getNewCSVReader().forEach {
            val row = arrayListOf<String>()
            selColumn.forEachIndexed { i, b ->
                if (b) {
                    row.add(it[i])
                }
            }
            result.add(row)
        }
        return result
    }

    private fun select2String(result: List<List<String>>): String {
        val buffer = StringBuffer()
        result.forEach {
            buffer.append(it.joinToString(postfix = "\n", separator = " | "))
        }
        return buffer.toString()
    }
}
