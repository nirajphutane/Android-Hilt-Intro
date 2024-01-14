package com.np.hilttutorial.features.crypto.fragments.buyAndSellCrypto.sell

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.np.hilttutorial.R
import com.np.hilttutorial.base_pkgs.BaseFragment
import com.np.hilttutorial.base_pkgs.viewBinding
import com.np.hilttutorial.databinding.FragmentSellcryptoBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SellCryptoFragment: BaseFragment(R.layout.fragment_sellcrypto) {

    private val binding by viewBinding<FragmentSellcryptoBinding>()

    @Inject lateinit var factory: SellCryptoViewModel.IViewModelFactory

    private val viewModel: SellCryptoViewModel by viewModels {
        SellCryptoViewModel.viewModelFactory(
            assistedFactory = factory,
            data = Pair("aireal@coin.com","Aireal@123")
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            bitcoin.setOnClickListener {
                viewModel.sellBitcoin()
            }
            ethereum.setOnClickListener {
                viewModel.sellEthereum()
            }
            back.setOnClickListener {
                findNavController().navigate(R.id.back)
            }
        }
    }
}