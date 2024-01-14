package com.np.hilttutorial.features.crypto.crypto.hiltModules.cryptoServicePortal

import com.np.hilttutorial.features.crypto.crypto.hiltModules.CryptoServicePortalScope
import com.np.hilttutorial.features.crypto.crypto.hiltModules.Param1
import com.np.hilttutorial.features.crypto.crypto.hiltModules.Param2
import dagger.BindsInstance
import dagger.hilt.DefineComponent
import dagger.hilt.components.SingletonComponent

@DefineComponent(parent = SingletonComponent::class)
//@DefineComponent(parent = ActivityRetainedComponent::class)
@CryptoServicePortalScope
interface ICryptoServicePortalComponent {

    @DefineComponent.Builder
    interface Builder {
        fun setUsername(@Param1 @BindsInstance username: String): Builder
        fun setPassword(@Param2 @BindsInstance password: String): Builder
        fun build(): ICryptoServicePortalComponent
    }
}
