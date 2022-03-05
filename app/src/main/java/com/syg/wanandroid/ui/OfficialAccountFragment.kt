package com.syg.wanandroid.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.syg.wanandroid.base.BaseFragment
import com.syg.wanandroid.databinding.FragmentOfficialAccountBinding
import com.syg.wanandroid.ui.adapters.OfficialAccountPagerAdapter

class OfficialAccountFragment : BaseFragment() {
    private lateinit var binding: FragmentOfficialAccountBinding
    private lateinit var tabLayout: TabLayout
    private val args by navArgs<OfficialAccountFragmentArgs>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOfficialAccountBinding.inflate(inflater, container, false)

        val oaName = args.oaName
        binding.tvOaName.text = oaName
        val bottomSheet = binding.include
        tabLayout = bottomSheet.tab
        val viewPager = bottomSheet.viewPagerOa
        val officialAccountPagerAdapter = OfficialAccountPagerAdapter(requireActivity())
        viewPager.adapter = officialAccountPagerAdapter

        TabLayoutMediator(tabLayout, viewPager) {tab,position->
            tab.text = "OBJECT ${(position + 1)}"
        }.attach()
        val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet.root)
//        if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_EXPANDED){
//            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
//        }else{
//            bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
//        }
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
        return binding.root
    }
}