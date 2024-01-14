package com.np.hilttutorial.features.crypto.fragments.adapter

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.np.hilttutorial.R
import com.np.hilttutorial.base_pkgs.BaseFragment
import com.np.hilttutorial.base_pkgs.viewBinding
import com.np.hilttutorial.databinding.FragmentCryptoadapterBinding
import com.np.hilttutorial.features.crypto.crypto.services.ICryptoAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CryptoAdapterFragment : BaseFragment(R.layout.fragment_cryptoadapter) {

    private val viewModel: CryptoAdapterViewModel by viewModels()
    private val binding by viewBinding<FragmentCryptoadapterBinding>()

    @Inject
    lateinit var cryptoAdapter: ICryptoAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            back.setOnClickListener {
                findNavController().navigate(R.id.back)
            }
        }

        cryptoAdapter.run {
            for(crypto in getList("CoinbaseAPI")) {
                Log.d("CryptoAdapterFragment", crypto.toString())
            }
        }
    }
}