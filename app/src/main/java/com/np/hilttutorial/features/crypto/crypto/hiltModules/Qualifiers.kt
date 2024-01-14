package com.np.hilttutorial.features.crypto.crypto.hiltModules

import javax.inject.Qualifier
import javax.inject.Scope

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class BitcoinQualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class EthereumQualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Param1

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Param2

@Scope
@Retention(AnnotationRetention.BINARY)
annotation class CryptoServicePortalScope