package com.np.hilttutorial.features.crypto.crypto.providers.gemini

import com.np.hilttutorial.features.crypto.crypto.currencies.ICrypto
import javax.inject.Inject

// Hilt: Constructor injection
class GeminiCryptoProvider @Inject constructor(private val crypto: ICrypto) : IGeminiCryptoProvider {

    override fun getPrice(): Double = crypto.getPrice()

    override fun getVolume (): Int = crypto.getVolume()
}