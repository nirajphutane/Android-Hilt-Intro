package com.np.hilttutorial.features.crypto.crypto.buyAndSellService.buy

import android.util.Log
import com.np.hilttutorial.features.crypto.crypto.currencies.ICrypto
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

class BuyCryptoService @AssistedInject constructor(
    @Assisted private val crypto: ICrypto,
    @Assisted("Quantity") private val quantity: Int,
    @Assisted("LimitPrice") private val limitPrice: Double,
    @Assisted("StopLoss") private val stopLoss: Double
) {

    fun buy() =
        Log.d("BuyCryptoService",
            "Bought ${crypto.getName()} Quantity: $quantity at Price: $limitPrice with StopLoss: $stopLoss")
}