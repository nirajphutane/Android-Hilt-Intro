package com.np.hilttutorial.features.crypto.fragments.buyAndSellCrypto.buy

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.np.hilttutorial.R
import com.np.hilttutorial.base_pkgs.BaseFragment
import com.np.hilttutorial.base_pkgs.viewBinding
import com.np.hilttutorial.databinding.FragmentBuycryptoBinding
import com.np.hilttutorial.features.crypto.crypto.currencies.ICrypto
import com.np.hilttutorial.features.crypto.crypto.buyAndSellService.buy.BuyCryptoService
import com.np.hilttutorial.features.crypto.crypto.hiltModules.BitcoinQualifier
import com.np.hilttutorial.features.crypto.crypto.hiltModules.EthereumQualifier
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class BuyCryptoFragment: BaseFragment(R.layout.fragment_buycrypto) {

    private val binding by viewBinding<FragmentBuycryptoBinding>()
    private val viewModel: BuyCryptoViewModel by viewModels()

    @BitcoinQualifier
    @Inject
    lateinit var bitcoinCrypto: ICrypto

    @EthereumQualifier
    @Inject
    lateinit var ethereumCrypto: ICrypto

    @Inject
    lateinit var buyCryptoServiceFactory: IBuyCryptoServiceFactory
    private lateinit var buyCryptoService: BuyCryptoService

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            bitcoin.setOnClickListener {
                buyCryptoService = buyCryptoServiceFactory.create(bitcoinCrypto, 10,64573.0, 60573.0)
                buyCryptoService.buy()
            }
            ethereum.setOnClickListener {
                buyCryptoService = buyCryptoServiceFactory.create(ethereumCrypto, 20,24570.0, 22570.0)
                buyCryptoService.buy()
            }
            back.setOnClickListener {
                findNavController().navigate(R.id.back)
            }
        }
    }

    @AssistedFactory
    interface IBuyCryptoServiceFactory {
        fun create(crypto: ICrypto, @Assisted("Quantity")quantity: Int, @Assisted("LimitPrice")price: Double, @Assisted("StopLoss")stopLoss: Double): BuyCryptoService
    }
}