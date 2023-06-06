package com.ercodesistant.guide_app.ui.information

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.ercodesistant.guide_app.R
import com.ercodesistant.guide_app.databinding.FragmentInformationBinding

class InformationFragment : Fragment() {

    private var _binding: FragmentInformationBinding? = null
    private lateinit var welcomeImage: ImageView

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val informationViewModel =
            ViewModelProvider(this).get(InformationViewModel::class.java)

        _binding = FragmentInformationBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textInformation
//        informationViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

//        binding.imagePemrograman.setOnClickListener {
//            var fr = supportFragmentManager.beginTransaction()
//            fr.add(R.id.imagePemrograman, CodingCateFragment())
//            fr.commit()
//        }

        welcomeImage = root.findViewById(R.id.imagePemrograman)

        welcomeImage.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.action_navigation_informasi_to_navigation_codesub)
        }

        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}