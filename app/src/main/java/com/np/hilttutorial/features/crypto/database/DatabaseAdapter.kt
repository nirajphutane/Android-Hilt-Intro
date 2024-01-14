package com.np.hilttutorial.features.crypto.database

import android.content.Context
import android.util.Log
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

// Hilt: Constructor injection
class DatabaseAdapter @Inject constructor(
    private val databaseService: DatabaseService,
    @ApplicationContext private val context: Context,
    @ActivityContext private val activityContext: Context
    ) {

    fun showData(table: String) {
        val data = databaseService.read(table)
        Log.d("Application Context", "$context")
        Log.d("Activity Context", "$activityContext")
        for(user in data) {
            Log.d("DatabaseAdapter", "$user")
        }
    }
}