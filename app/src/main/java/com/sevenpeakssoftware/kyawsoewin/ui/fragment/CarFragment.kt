package com.sevenpeakssoftware.kyawsoewin.ui.fragment

import android.view.LayoutInflater
import androidx.fragment.app.viewModels
import com.sevenpeakssoftware.kyawsoewin.databinding.FragmentCarListBinding
import com.sevenpeakssoftware.kyawsoewin.extensions.*
import com.sevenpeakssoftware.kyawsoewin.presentation.CarListViewModel
import com.sevenpeakssoftware.kyawsoewin.presentation.ViewState
import com.sevenpeakssoftware.kyawsoewin.ui.activity.MainActivity
import com.sevenpeakssoftware.kyawsoewin.ui.adapter.CarListAdapter
import com.sevenpeakssoftware.kyawsoewin.ui.base.fragment.BaseViewBindingFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CarFragment : BaseViewBindingFragment<FragmentCarListBinding>() {

    private val carListViewModel: CarListViewModel by viewModels()
    override fun bindView(inflater: LayoutInflater): FragmentCarListBinding =
        FragmentCarListBinding.inflate(inflater)

    private val carListAdapter: CarListAdapter by lazy {
        CarListAdapter()
    }

    override fun setUp() {
        super.setUp()
        (requireActivity() as MainActivity).supportActionBar?.show()
        binding.rvCar.setUpCustomAdapter(isLinear = true, adapterName = carListAdapter)
    }

    override fun observe() {
        super.observe()

        carListViewModel.cacheCarListLiveData.observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                binding.txtNoData.hideView()
            } else {
                binding.txtNoData.showView()
                carListAdapter.submitList(it)
            }
        }
        carListViewModel.carListLiveData.observe(viewLifecycleOwner) {
            when (it) {
                is ViewState.Success -> {
                    carListViewModel.getCacheList()
                }
                is ViewState.NetworkError -> {
                    carListViewModel.getCacheList()
                }
                is ViewState.Loading -> {
                }
                is ViewState.ServerError -> {
                    showToast("Server Error")
                    carListViewModel.getCacheList()
                }
                is ViewState.ResourceNotFound -> {
                    showToast("Resource Not Found Error")
                    carListViewModel.getCacheList()
                }
                is ViewState.Error -> {
                    showToast(it.message)
                    carListViewModel.getCacheList()
                }
                is ViewState.Unauthorized -> showLog("Unauthorized")
            }
        }
    }

    override fun onDestroyView() {
        binding.rvCar.removeAdapter()
        super.onDestroyView()
    }
}