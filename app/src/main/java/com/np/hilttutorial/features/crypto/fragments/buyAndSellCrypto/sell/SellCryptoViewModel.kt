package com.np.hilttutorial.features.crypto.fragments.buyAndSellCrypto.sell

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.np.hilttutorial.base_pkgs.BaseViewModel
import com.np.hilttutorial.features.crypto.crypto.buyAndSellService.sell.SellCryptoService
import com.np.hilttutorial.features.crypto.crypto.currencies.ICrypto
import com.np.hilttutorial.features.crypto.crypto.hiltModules.BitcoinQualifier
import com.np.hilttutorial.features.crypto.crypto.hiltModules.EthereumQualifier
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import javax.inject.Inject

// In Dagger 2.31, it's possible to achieve the above without using @HiltViewModel and passing everything manually
// @HiltViewModel is commented here as below
// @HiltViewModel
class SellCryptoViewModel @AssistedInject constructor(
    @Assisted val data: Pair<String, String>
) : BaseViewModel() {

    @BitcoinQualifier
    @Inject
    lateinit var bitcoinCrypto: ICrypto

    @EthereumQualifier
    @Inject
    lateinit var ethereumCrypto: ICrypto

    @Inject
    lateinit var sellCryptoServiceFactory: ISellCryptoServiceFactory
    private lateinit var sellCryptoService: SellCryptoService

    init {
        Log.d("SellCryptoViewModel", "UserName: ${data.first}, Password: ${data.second}")
    }

    fun sellBitcoin() {
        sellCryptoService = sellCryptoServiceFactory.create(bitcoinCrypto, 10,64573.0, 60573.0)
        sellCryptoService.sell()
    }

    fun sellEthereum() {
        sellCryptoService = sellCryptoServiceFactory.create(ethereumCrypto, 20,24570.0, 22570.0)
        sellCryptoService.sell()
    }

    @AssistedFactory
    interface ISellCryptoServiceFactory {
        fun create(crypto: ICrypto, @Assisted("Quantity")quantity: Int, @Assisted("LimitPrice")price: Double, @Assisted("TriggerPrice")triggerPrice: Double): SellCryptoService
    }

    @AssistedFactory
    interface IViewModelFactory {
        fun create(data: Pair<String, String>): SellCryptoViewModel
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        fun viewModelFactory(
            assistedFactory: IViewModelFactory,
            data: Pair<String, String>
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return assistedFactory.create(data) as T
            }
        }
    }
}