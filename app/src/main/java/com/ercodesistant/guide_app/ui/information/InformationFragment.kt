package com.ercodesistant.guide_app.ui.information

import android.media.Image
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
    private lateinit var codeImage: ImageView
    private lateinit var designImage: ImageView
    private lateinit var aiImage: ImageView
    private lateinit var photoImage: ImageView
    private lateinit var videoImage: ImageView
    private lateinit var OtherImage: ImageView

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

        codeImage = root.findViewById(R.id.imagePemrograman)

        codeImage.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.action_navigation_informasi_to_navigation_codesub)
        }

        designImage = root.findViewById(R.id.imageDesain)

        designImage.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.action_navigation_informasi_to_navigation_designsub)
        }

        aiImage = root.findViewById(R.id.imageai)

        aiImage.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.action_navigation_informasi_to_navigation_designsub)
        }

        photoImage = root.findViewById(R.id.imageFotografi)

        photoImage.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.action_navigation_informasi_to_navigation_designsub)
        }

        videoImage = root.findViewById(R.id.imageVideo)

        videoImage.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.action_navigation_informasi_to_navigation_designsub)
        }

        OtherImage = root.findViewById(R.id.imageOther)

        OtherImage.setOnClickListener {
            Navigation.findNavController(root).navigate(R.id.action_navigation_informasi_to_navigation_designsub)
        }




        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}