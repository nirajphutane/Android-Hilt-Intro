package com.np.hilttutorial.base_pkgs

import androidx.annotation.ContentView
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment

open class BaseFragment: Fragment {

    constructor(): super()

    @ContentView
    constructor(@LayoutRes containLayoutId: Int): super(containLayoutId)
}