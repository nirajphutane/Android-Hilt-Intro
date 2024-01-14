package com.np.hilttutorial.features.crypto.crypto.hiltModules

import com.np.hilttutorial.features.crypto.crypto.currencies.Bitcoin
import com.np.hilttutorial.features.crypto.crypto.currencies.Ethereum
import com.np.hilttutorial.features.crypto.crypto.currencies.ICrypto
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
abstract class AbstractCryptoCurrencyModule {

    @BitcoinQualifier
    @Binds
    abstract fun bindBitcoin(bitcoin: Bitcoin): ICrypto

    @EthereumQualifier
    @Binds
    abstract fun bindEthereum(ethereum: Ethereum): ICrypto
}