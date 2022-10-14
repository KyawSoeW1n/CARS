package com.sevenpeakssoftware.kyawsoewin.ui.fragment

import android.view.LayoutInflater
import androidx.fragment.app.viewModels
import com.sevenpeakssoftware.kyawsoewin.databinding.FragmentCarListBinding
import com.sevenpeakssoftware.kyawsoewin.extensions.setUpCustomAdapter
import com.sevenpeakssoftware.kyawsoewin.extensions.showLog
import com.sevenpeakssoftware.kyawsoewin.extensions.showToast
import com.sevenpeakssoftware.kyawsoewin.presentation.GetCarListViewModel
import com.sevenpeakssoftware.kyawsoewin.presentation.ViewState
import com.sevenpeakssoftware.kyawsoewin.ui.adapter.CarListAdapter
import com.sevenpeakssoftware.kyawsoewin.ui.base.fragment.BaseViewBindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CarFragment : BaseViewBindingFragment<FragmentCarListBinding>() {

    private val getCarListViewModel: GetCarListViewModel by viewModels()
    override fun bindView(inflater: LayoutInflater): FragmentCarListBinding =
        FragmentCarListBinding.inflate(inflater)

    private val carListAdapter: CarListAdapter by lazy {
        CarListAdapter()
    }

    override fun setUp() {
        super.setUp()
        binding.rvCar.setUpCustomAdapter(isLinear = true, adapterName = carListAdapter)
    }

    override fun observe() {
        super.observe()

        getCarListViewModel.cacheCarListLiveData.observe(viewLifecycleOwner) {
            carListAdapter.submitList(it)
        }
        getCarListViewModel.carListLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is ViewState.Success -> {
                    getCarListViewModel.getCacheList()
                }
                is ViewState.NetworkError -> {
                    getCarListViewModel.getCacheList()
                }
                is ViewState.Loading -> {
                }
                is ViewState.ServerError -> {
                    showToast("Server Error")
                    getCarListViewModel.getCacheList()
                }
                is ViewState.ResourceNotFound -> {
                    showToast("Resource Not Found Error")
                    getCarListViewModel.getCacheList()
                }
                is ViewState.Error -> {
                    showToast(it.message)
                    getCarListViewModel.getCacheList()
                }
                is ViewState.Unauthorized -> showLog("Unauthorized")
            }
        }
    }

    override fun onDestroyView() {
        binding.rvCar.apply {
            adapter = null
        }
        super.onDestroyView()
    }
}