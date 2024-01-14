package com.np.hilttutorial.features.crypto.crypto.providers.gemini

interface IGeminiCryptoProvider {

    fun getPrice (): Double
    fun getVolume (): Int
}