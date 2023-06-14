package com.ercodesistant.guide_app.ui.information.subCodeCategory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.ercodesistant.guide_app.databinding.FragmentCodingcateBinding
import com.ercodesistant.guide_app.network.WebLinkApi
import com.ercodesistant.guide_app.ui.information.subAICategory.AICateAdapter
import com.ercodesistant.guide_app.ui.information.subAICategory.AICateViewModel

class CodingCateFragment: Fragment() {

//    private var _binding: FragmentCodingcateBinding? = null
//
//    private val binding get() = _binding!!

    private val viewModel: AICateViewModel by lazy {
        ViewModelProvider(this)[AICateViewModel::class.java]
    }

    private lateinit var binding: FragmentCodingcateBinding
    private lateinit var myAdapter: AICateAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val CodingCateViewModel =
//            ViewModelProvider(this).get(CodingCateViewModel::class.java)
//
//        _binding = FragmentCodingcateBinding.inflate(inflater, container, false)
//        val root: View = binding.root
//
//        return root
        binding = FragmentCodingcateBinding.inflate(layoutInflater, container, false)
        myAdapter = AICateAdapter()
        with(binding.recyclerView) {
            addItemDecoration(
                DividerItemDecoration(context,
                    RecyclerView.VERTICAL)
            )
            adapter = myAdapter
            setHasFixedSize(true)
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getData().observe(viewLifecycleOwner){
            myAdapter.updateData(it)
        }
        viewModel.getStatus().observe(viewLifecycleOwner) {
            updateProgress(it)
        }
    }

    private fun updateProgress(status: WebLinkApi.ApiStatus) {
        when (status) {
            WebLinkApi.ApiStatus.LOADING -> {
                binding.progressBar.visibility = View.VISIBLE
            }
            WebLinkApi.ApiStatus.SUCCESS -> {
                binding.progressBar.visibility = View.GONE
            }
            WebLinkApi.ApiStatus.FAILED -> {
                binding.progressBar.visibility = View.GONE
                binding.networkError.visibility = View.VISIBLE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //_binding = null
    }
}
