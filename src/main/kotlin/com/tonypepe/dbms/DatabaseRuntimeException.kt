package com.tonypepe.dbms

open class DatabaseRuntimeException(message: String = "Database Error") : RuntimeException(message)

class QueryError(message: String = "Query Error") : DatabaseRuntimeException(message)
