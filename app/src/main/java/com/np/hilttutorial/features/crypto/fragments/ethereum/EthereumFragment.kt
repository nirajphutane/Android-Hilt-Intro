package com.np.hilttutorial.features.crypto.fragments.ethereum

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.np.hilttutorial.R
import com.np.hilttutorial.base_pkgs.BaseFragment
import com.np.hilttutorial.base_pkgs.viewBinding
import com.np.hilttutorial.databinding.FragmentEthereumBinding
import com.np.hilttutorial.features.crypto.crypto.currencies.Ethereum
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class EthereumFragment: BaseFragment(R.layout.fragment_ethereum) {

    private val binding by viewBinding<FragmentEthereumBinding>()
    private val viewModel: EthereumViewModel by viewModels()

    @Inject
    lateinit var ethereum: Ethereum

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            back.setOnClickListener {
                findNavController().navigate(R.id.back)
            }
        }

        // Calling Method Injection explicitly
        Log.d("EthereumFragment", "Call explicitly")
        ethereum(ethereum)      // Explicitly call
    }

    // Hilt: Method injection
    // Hilt: It called implicitly at once, no need to call explicitly, but we can call it explicitly.
    @Inject
    fun ethereum(ethereum: Ethereum) {
        ethereum.run {
            Log.d("EthereumFragment", "Ethereum Price: ${getPrice()}")
            Log.d("EthereumFragment", "Ethereum Volume: ${getVolume()}")
        }
    }
}