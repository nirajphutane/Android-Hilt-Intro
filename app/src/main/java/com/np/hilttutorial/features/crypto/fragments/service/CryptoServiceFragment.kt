package com.np.hilttutorial.features.crypto.fragments.service

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.np.hilttutorial.R
import com.np.hilttutorial.base_pkgs.BaseFragment
import com.np.hilttutorial.base_pkgs.viewBinding
import com.np.hilttutorial.databinding.FragmentCryptoserviceBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CryptoServiceFragment : BaseFragment(R.layout.fragment_cryptoservice) {

    private val viewModel: CryptoServiceViewModel by viewModels()

    private val binding by viewBinding<FragmentCryptoserviceBinding>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            cryptoAdapter.setOnClickListener {
                findNavController().navigate(R.id.cryptoAdapter)
            }
            back.setOnClickListener {
                findNavController().navigate(R.id.back)
            }
        }
    }
}