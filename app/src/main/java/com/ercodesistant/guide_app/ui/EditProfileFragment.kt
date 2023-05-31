package com.ercodesistant.guide_app.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ercodesistant.guide_app.databinding.FragmentEditProfileBinding

//class EditProfileFragment: Fragment(R.layout.fragment_edit_profile)

class EditProfileFragment : Fragment(){

    private var _binding : FragmentEditProfileBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }
}