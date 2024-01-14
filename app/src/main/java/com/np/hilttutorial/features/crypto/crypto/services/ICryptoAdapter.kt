package com.np.hilttutorial.features.crypto.crypto.services

import java.util.ArrayList

interface ICryptoAdapter {
    fun getList(api: String): ArrayList<out Map<String, Any>>
}