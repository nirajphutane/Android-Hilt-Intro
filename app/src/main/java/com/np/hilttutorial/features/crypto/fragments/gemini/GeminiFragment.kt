package com.np.hilttutorial.features.crypto.fragments.gemini

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.np.hilttutorial.R
import com.np.hilttutorial.base_pkgs.BaseFragment
import com.np.hilttutorial.base_pkgs.viewBinding
import com.np.hilttutorial.databinding.FragmentGeminiBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GeminiFragment: BaseFragment(R.layout.fragment_gemini) {

    private val binding by viewBinding<FragmentGeminiBinding>()
    private val viewModel: GeminiViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.run {
            back.setOnClickListener {
                findNavController().navigate(R.id.back)
            }
        }
    }
}