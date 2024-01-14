package com.np.hilttutorial.features.crypto.crypto.hiltModules.cryptoServicePortal

import com.np.hilttutorial.features.crypto.crypto.services.CryptoServicePortal
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn

@EntryPoint
@InstallIn(ICryptoServicePortalComponent::class)
interface CryptoServicePortalEntryPoint {

    fun provideCryptoServicePortal(): CryptoServicePortal
}