package com.np.hilttutorial.features.crypto.crypto.services

import android.content.Context
import android.util.Log
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.ArrayList
import javax.inject.Inject

// Hilt: Constructor injection
class CryptoAdapter @Inject constructor(
    private val cryptoService: CryptoService,
    @ApplicationContext private val context: Context,
    @ActivityContext private val activityContext: Context
) : ICryptoAdapter {

    override fun getList(api: String) : ArrayList<out Map<String, Any>> {
        Log.d("CryptoAdapter","API: $api")
        Log.d("CryptoAdapter","Application Context: $context")
        Log.d("CryptoAdapter","Activity Context: $activityContext")
        return  cryptoService.get()
    }
}