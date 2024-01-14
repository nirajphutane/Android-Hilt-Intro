package com.np.hilttutorial.features.crypto.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.np.hilttutorial.R
import com.np.hilttutorial.base_pkgs.BaseFragment
import com.np.hilttutorial.base_pkgs.viewBinding
import com.np.hilttutorial.databinding.FragmentCryptoBinding
import com.np.hilttutorial.features.crypto.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CryptoFragment: BaseFragment(R.layout.fragment_crypto) {

    private val binding by viewBinding<FragmentCryptoBinding>()
    private val viewModel: CryptoViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            showCrypto.setOnClickListener {
                viewModel.getCurrencies()
            }
            hide.setOnClickListener {
                viewModel.stopUpdates = true
                (activity as MainActivity).hideNavHost()
            }
            buyCrypto.setOnClickListener {
                findNavController().navigate(R.id.buyCrypto)
            }
            sellCrypto.setOnClickListener {
                findNavController().navigate(R.id.sellCrypto)
            }
            bitcoin.setOnClickListener {
                findNavController().navigate(R.id.bitcoin)
            }
            ethereum.setOnClickListener {
                findNavController().navigate(R.id.ethereum)
            }
            coinbase.setOnClickListener {
                findNavController().navigate(R.id.coinbase)
            }
            gemini.setOnClickListener {
                findNavController().navigate(R.id.gemini)
            }
            cryptoServicePortal.setOnClickListener {
                findNavController().navigate(R.id.cryptoServicePortal)
            }
            cryptoAdaptor.setOnClickListener {
                findNavController().navigate(R.id.cryptoAdapter)
            }
        }

        viewModel.currenciesLiveData.observe(this) {
            Log.d("CryptoFragment", "$it")
        }
    }
}