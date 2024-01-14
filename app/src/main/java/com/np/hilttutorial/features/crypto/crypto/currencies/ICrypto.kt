package com.np.hilttutorial.features.crypto.crypto.currencies

interface ICrypto {
    fun getName(): String
    fun getPrice (): Double
    fun getVolume (): Int
}