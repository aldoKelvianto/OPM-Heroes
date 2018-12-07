package com.aldoapps.opmsclass.util

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aldoapps.opmsclass.hero.view.HeroAdapter
import com.aldoapps.opmsclass.hero.view.HeroModel
import de.hdodenhof.circleimageview.CircleImageView

/**
 * Created by aldo on 04/01/18.
 */

@BindingAdapter("loadImage")
fun loadImageWithResource(
  view: CircleImageView,
  resId: Int
) {
  view.setImageResource(resId)
}

@BindingAdapter("isVisible")
fun setVisibility(
  view: ProgressBar,
  isVisible: Boolean
) {
  view.visibility = if (isVisible) View.VISIBLE else View.GONE
}

@BindingAdapter("bindHeroList")
fun bindData(
  view: RecyclerView,
  data: List<HeroModel>?
) {
  val heroAdapter = view.adapter as HeroAdapter
  data ?: return
  heroAdapter.addHeroList(data)
}