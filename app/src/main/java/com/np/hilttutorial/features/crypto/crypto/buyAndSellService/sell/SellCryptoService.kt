package com.np.hilttutorial.features.crypto.crypto.buyAndSellService.sell

import android.util.Log
import com.np.hilttutorial.features.crypto.crypto.currencies.ICrypto
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

class SellCryptoService @AssistedInject constructor(
    @Assisted private val crypto: ICrypto,
    @Assisted("Quantity") private val quantity: Int,
    @Assisted("LimitPrice") private val limitPrice: Double,
    @Assisted("TriggerPrice") private val triggerPrice: Double
) {

    fun sell() =
        Log.d("SellCryptoService",
            "Sold ${crypto.getName()} Quantity: $quantity with Limit Price: $limitPrice and Trigger Price: $triggerPrice")
}