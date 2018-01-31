package com.aldoapps.opmsclass.util

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
    view.visibility = if (isVisible) View.VISIBLE else View.GONE
}
