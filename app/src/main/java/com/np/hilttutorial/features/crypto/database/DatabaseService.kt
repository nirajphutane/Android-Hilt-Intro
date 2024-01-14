package com.np.hilttutorial.features.crypto.database

import android.util.Log
import java.util.ArrayList
import javax.inject.Inject

const val Id = "ID"
const val Name = "Name"
const val EmailId = "EmailId"

// Hilt: Constructor injection
class DatabaseService @Inject constructor() {

    private val data = arrayListOf(
        mapOf(
            Id to 0,
            Name to "John",
            EmailId to "John@kts.com"
        ),
        mapOf(
            Id to 1,
            Name to "Pit",
            EmailId to "Pit@kts.com"
        ),
        mapOf(
            Id to 2,
            Name to "Paul",
            EmailId to "Paul@kts.com"
        ),
        mapOf(
            Id to 3,
            Name to "Thomas",
            EmailId to "Thomas@kts.com"
        ),
        mapOf(
            Id to 4,
            Name to "Emma",
            EmailId to "Emma@kts.com"
        ),
        mapOf(
            Id to 5,
            Name to "Natali",
            EmailId to "Natali@kts.com"
        ),
        mapOf(
            Id to 6,
            Name to "Sia",
            EmailId to "Sia@kts.com"
        )
    )

    fun read(table: String): ArrayList<out Map<String, Any>> {
        Log.d("DatabaseService", "Reading Table: $table")
        return data
    }
}