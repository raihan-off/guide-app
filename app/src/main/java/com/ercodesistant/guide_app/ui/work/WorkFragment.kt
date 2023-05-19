package com.ercodesistant.guide_app.ui.work

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ercodesistant.guide_app.databinding.FragmentWorkBinding

class WorkFragment : Fragment() {

    private var _binding: FragmentWorkBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val workViewModel = ViewModelProvider(this).get(WorkViewModel::class.java)

        _binding = FragmentWorkBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textWork
        workViewModel.text.observe(viewLifecycleOwner){
            textView.text = it
        }
        return root
    }
}