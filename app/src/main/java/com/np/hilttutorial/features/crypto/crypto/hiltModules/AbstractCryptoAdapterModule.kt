package com.np.hilttutorial.features.crypto.crypto.hiltModules

import com.np.hilttutorial.features.crypto.crypto.services.CryptoAdapter
import com.np.hilttutorial.features.crypto.crypto.services.ICryptoAdapter
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
abstract class AbstractCryptoAdapterModule {

    @Binds
    abstract fun bindCryptoAdapter(cryptoAdapter: CryptoAdapter): ICryptoAdapter
}