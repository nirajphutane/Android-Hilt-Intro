package com.np.hilttutorial.features.crypto.fragments

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.MutableLiveData
import com.np.hilttutorial.base_pkgs.BaseViewModel
import com.np.hilttutorial.features.crypto.crypto.services.CryptoService
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.ArrayList
import javax.inject.Inject

@HiltViewModel
class CryptoViewModel @Inject constructor(private val cryptoService: CryptoService): BaseViewModel() {

    val currenciesLiveData = MutableLiveData<ArrayList<Map<String, Any>>>()
    private lateinit var runnable: Runnable
    var stopUpdates = true

    fun getCurrencies() {
        val handler = Handler(Looper.getMainLooper())
        runnable = Runnable {
            currenciesLiveData.value = cryptoService.get()
            if(!stopUpdates) {
                handler.postDelayed(runnable, 5000)
            }
        }
        stopUpdates = false
        handler.postDelayed(runnable, 0)
    }

}