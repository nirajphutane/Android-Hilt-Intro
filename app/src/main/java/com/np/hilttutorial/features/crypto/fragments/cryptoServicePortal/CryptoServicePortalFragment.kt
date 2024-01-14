package com.np.hilttutorial.features.crypto.fragments.cryptoServicePortal

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.np.hilttutorial.R
import com.np.hilttutorial.base_pkgs.BaseFragment
import com.np.hilttutorial.base_pkgs.viewBinding
import com.np.hilttutorial.databinding.FragmentCryptoserviceportalBinding
import com.np.hilttutorial.features.crypto.crypto.hiltModules.cryptoServicePortal.CryptoServicePortalManager
import com.np.hilttutorial.features.crypto.crypto.services.CryptoServicePortal
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CryptoServicePortalFragment: BaseFragment(R.layout.fragment_cryptoserviceportal) {

    private val binding by viewBinding<FragmentCryptoserviceportalBinding>()
    private val viewModel: CryptoServicePortalViewModel by viewModels()

    @Inject
    lateinit var cryptoServicePortalManager: CryptoServicePortalManager

    lateinit var cryptoServicePortal: CryptoServicePortal

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            back.setOnClickListener {
                findNavController().navigate(R.id.back)
            }
        }

        cryptoServicePortalManager.setParams("MyCrypto", "crypto@curr.com")
        cryptoServicePortal = cryptoServicePortalManager.cryptoServicePortal

        cryptoServicePortal.login()
    }
}