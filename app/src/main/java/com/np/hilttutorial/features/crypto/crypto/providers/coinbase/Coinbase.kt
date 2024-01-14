package com.np.hilttutorial.features.crypto.crypto.providers.coinbase

import android.util.Log
import com.np.hilttutorial.features.crypto.crypto.currencies.ICrypto

/*Consider this is 3th party library. So we need to use as it is.*/

class Coinbase private constructor(builder: Builder) {

    private val userName: String
    private val pin: Int?
    private val crypto: ICrypto

    init {
        this.userName = builder.userName
        this.pin = builder.pin
        this.crypto = builder.crypto
        Log.d("Coinbase", "Crypto: ${crypto.getName()}")
    }

    fun getPrice() : Double = crypto.getPrice()

    fun getVolume() : Int = crypto.getVolume()

    class Builder(var userName: String, var crypto: ICrypto) {

        var pin: Int? = null
            private set

        fun setPin(pin: Int) = apply { this.pin = pin }

        fun build() = Coinbase(this)
    }
}