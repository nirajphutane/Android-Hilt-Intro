package com.np.hilttutorial.features.crypto.fragments.coinbase

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.np.hilttutorial.R
import com.np.hilttutorial.base_pkgs.BaseFragment
import com.np.hilttutorial.base_pkgs.viewBinding
import com.np.hilttutorial.databinding.FragmentCoinbaseBinding
import com.np.hilttutorial.features.crypto.crypto.providers.coinbase.Coinbase
import com.np.hilttutorial.features.crypto.crypto.hiltModules.BitcoinQualifier
import com.np.hilttutorial.features.crypto.crypto.hiltModules.EthereumQualifier
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CoinbaseFragment: BaseFragment(R.layout.fragment_coinbase) {

    private val binding by viewBinding<FragmentCoinbaseBinding>()
    private val viewModel: CoinbaseViewModel by viewModels()

    @BitcoinQualifier
    @Inject
    lateinit var bitcoin: Coinbase

    @EthereumQualifier
    @Inject
    lateinit var ethereum: Coinbase

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            back.setOnClickListener {
                findNavController().navigate(R.id.back)
            }
        }

        bitcoin.run {
            Log.d("CoinbaseFragment", "Bitcoin Price: ${getPrice()}")
            Log.d("CoinbaseFragment", "Bitcoin Volume: ${getVolume()}")
        }

        ethereum.run {
            Log.d("CoinbaseFragment", "Ethereum Price: ${getPrice()}")
            Log.d("CoinbaseFragment", "Ethereum Volume: ${getVolume()}")
        }
    }
}