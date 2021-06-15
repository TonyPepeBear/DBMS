package com.tonypepe.dbms

object DBMS {
    private val selectedDatabase = ""

    fun query(q: String) {
        val split = q.split(" ")
        when (split[0].uppercase())  {
            "CREATE" -> {
                create(split)
            }
            else -> {
                TODO()
            }
        }
    }

    private fun create(split: List<String>) {
        when (split[1].uppercase()) {
            "DATABASE" -> {
                TODO()
            }
            "TABLE" -> {
                TODO()
            }
        }
    }
}
