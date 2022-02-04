package com.syg.wanandroid.base

import android.app.ProgressDialog
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.syg.wanandroid.anno.FragmentConfiguration

abstract class BaseFragment() : Fragment(), IUiView {

    private var useEventBus = false

    init {
        this.javaClass.getAnnotation(FragmentConfiguration::class.java)?.let {
            useEventBus = it.useEventBus
        }
    }

    private var progressDialog: ProgressDialog? = null

    override fun showLoading() {
        if (progressDialog == null)
            progressDialog = ProgressDialog(requireActivity())
        progressDialog?.show()
    }

    override fun dismissLoading() {
        progressDialog?.takeIf { it.isShowing }?.dismiss()
    }
}