package com.np.hilttutorial.features.crypto.crypto.hiltModules

import com.np.hilttutorial.features.crypto.crypto.providers.coinbase.Coinbase
import com.np.hilttutorial.features.crypto.crypto.providers.gemini.GeminiCryptoProvider
import com.np.hilttutorial.features.crypto.crypto.currencies.Bitcoin
import com.np.hilttutorial.features.crypto.crypto.currencies.Ethereum
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class CryptoProvideModule {

    @BitcoinQualifier
    @Provides
    fun provideCoinbaseForBitCoin(): Coinbase {
        return Coinbase
            .Builder("Paul@coinbase.com", Bitcoin())
            .setPin(1234)
            .build()
    }

    @EthereumQualifier
    @Provides
    fun provideCoinbaseForEthereum(): Coinbase {
        return Coinbase
            .Builder("Paul@coinbase.com", Ethereum())
            .setPin(1234)
            .build()
    }

    @BitcoinQualifier
    @Provides
    fun provideGeminiForBitCoin(): GeminiCryptoProvider {
        return GeminiCryptoProvider(Bitcoin())
    }

    @EthereumQualifier
    @Provides
    fun provideGeminiForEthereum(): GeminiCryptoProvider {
        return GeminiCryptoProvider(Ethereum())
    }
}
