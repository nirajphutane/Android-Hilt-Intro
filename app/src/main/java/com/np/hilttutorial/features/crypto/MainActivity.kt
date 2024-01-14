package com.np.hilttutorial.features.crypto

import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import com.np.hilttutorial.base_pkgs.MainActivityViewModel
import com.np.hilttutorial.base_pkgs.WrapperActivity
import com.np.hilttutorial.base_pkgs.viewBinding
import com.np.hilttutorial.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : WrapperActivity() {

    private val viewModel: MainActivityViewModel by viewModels()
    private val binding by viewBinding(ActivityMainBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.run {
            showCrypto.setOnClickListener {
                showCrypto.isVisible = false
                navHostFragmentContainer.isVisible = true
            }
        }
    }

    fun hideNavHost() {
        binding.navHostFragmentContainer.isVisible = false
        binding.showCrypto.isVisible = true
    }
}