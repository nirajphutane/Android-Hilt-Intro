package com.np.hilttutorial.features.crypto.crypto.hiltModules.cryptoServicePortal

import com.np.hilttutorial.features.crypto.crypto.services.CryptoServicePortal
import dagger.hilt.EntryPoints
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject
import javax.inject.Provider

//@Singleton
@ActivityRetainedScoped
class CryptoServicePortalManager @Inject constructor(
    private val cryptoServicePortalComponentProvider: Provider<ICryptoServicePortalComponent.Builder>
) {
    var cryptoServicePortalComponent: ICryptoServicePortalComponent? = null
        private set

    lateinit var cryptoServicePortal: CryptoServicePortal
        private set

    fun setParams(username: String, password: String) {
        cryptoServicePortalComponent = cryptoServicePortalComponentProvider.get().setUsername(username).setPassword(password).build()
        cryptoServicePortal = EntryPoints.get(cryptoServicePortalComponent, CryptoServicePortalEntryPoint::class.java).provideCryptoServicePortal()
    }
}