package com.np.hilttutorial.features.crypto.crypto.currencies

import javax.inject.Inject
import kotlin.random.Random

// Hilt: Constructor injection
class Bitcoin @Inject constructor() : ICrypto {

    override fun getName(): String = "Bitcoin"

    override fun getPrice(): Double = Random.nextDouble(100000.0, 500000.0)

    override fun getVolume (): Int = Random.nextInt(100000, 500000)
}