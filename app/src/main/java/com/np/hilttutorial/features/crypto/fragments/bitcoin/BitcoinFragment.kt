package com.np.hilttutorial.features.crypto.fragments.bitcoin

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.np.hilttutorial.R
import com.np.hilttutorial.base_pkgs.BaseFragment
import com.np.hilttutorial.base_pkgs.viewBinding
import com.np.hilttutorial.databinding.FragmentBitcoinBinding
import com.np.hilttutorial.features.crypto.crypto.currencies.Bitcoin
import com.np.hilttutorial.features.crypto.crypto.currencies.ICrypto
import com.np.hilttutorial.features.crypto.crypto.hiltModules.BitcoinQualifier
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BitcoinFragment: BaseFragment(R.layout.fragment_bitcoin) {

    private val binding by viewBinding<FragmentBitcoinBinding>()
    private val viewModel: BitcoinViewModel by viewModels()

    @Inject
    lateinit var bitcoin: Bitcoin           // Hilt: Declare

    @BitcoinQualifier
    @Inject
    lateinit var bitcoinCrypto: ICrypto     // Hilt: Declare (Interface binding)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            back.setOnClickListener {
                findNavController().navigate(R.id.back)
            }
        }

        // Hilt: Field Injection
        bitcoin.run {
            Log.d("BitcoinFragment", "Bitcoin Price: ${getPrice()}")
            Log.d("BitcoinFragment", "Bitcoin Volume: ${getVolume()}")
        }

        // Hilt: Field Injection
        bitcoinCrypto.run {
            Log.d("BitcoinFragment", "ICrypto Bitcoin Price: ${getPrice()}")
            Log.d("BitcoinFragment", "ICrypto Bitcoin Volume: ${getVolume()}")
        }
    }
}