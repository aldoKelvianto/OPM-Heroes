package com.aldoapps.opmsclass

import android.databinding.BindingAdapter
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar

/**
 * Created by aldo on 04/01/18.
 */

@BindingAdapter("loadImage")
fun loadImageWithResource(view: ImageView, resId: Int) {
    view.setImageResource(resId)
}

@BindingAdapter("isVisible")
fun setVisibility(view: ProgressBar, isVisible: Boolean) {
    if (isVisible) {
        view.visibility = View.VISIBLE
    } else {
        view.visibility = View.GONE
    }
}
