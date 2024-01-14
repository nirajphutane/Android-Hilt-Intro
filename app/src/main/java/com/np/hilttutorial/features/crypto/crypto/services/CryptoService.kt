package com.np.hilttutorial.features.crypto.crypto.services

import java.util.*
import javax.inject.Inject
import kotlin.random.Random

const val Id = "ID"
const val Currency = "Currency"
const val Price = "Price"
const val Volume = "Volume"
const val DateTime = "DateTime"

// Hilt: Constructor injection
class CryptoService @Inject constructor() {

    fun get(): ArrayList<Map<String, Any>> {
        val cryptoCurrencies = arrayListOf<Map<String, Any>>()
        for((index, currency) in arrayListOf("Bitcoin", "Ethereum", "BNB", "Solana", "XRP", "TRON", "Litecoin").withIndex()) {
            cryptoCurrencies.add(
                mapOf(
                    Id to index,
                    Currency to currency,
                    Price to Random.nextDouble(100000.0, 500000.0),
                    Volume to Random.nextInt(100000, 500000),
                    DateTime to Calendar.getInstance().time
                )
            )
        }
        return cryptoCurrencies
    }
}