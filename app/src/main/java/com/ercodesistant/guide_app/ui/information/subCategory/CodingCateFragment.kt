package com.ercodesistant.guide_app.ui.information.subCategory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ercodesistant.guide_app.databinding.FragmentCodingcateBinding

class CodingCateFragment: Fragment() {

    private var _binding: FragmentCodingcateBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val CodingCateViewModel =
            ViewModelProvider(this).get(CodingCateViewModel::class.java)

        _binding = FragmentCodingcateBinding.inflate(inflater, container, false)
        val root: View = binding.root




        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
