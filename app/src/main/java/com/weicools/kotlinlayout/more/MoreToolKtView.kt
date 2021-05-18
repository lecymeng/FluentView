package com.weicools.kotlinlayout.more

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.weicools.kotlinlayout.R
import com.weicools.kotlinlayout.widget.background_colorResource
import com.weicools.kotlinlayout.widget.chainPacked
import com.weicools.kotlinlayout.widget.constraintLayoutParams
import com.weicools.kotlinlayout.widget.createRefs
import com.weicools.kotlinlayout.widget.dp
import com.weicools.kotlinlayout.widget.imageView
import com.weicools.kotlinlayout.widget.image_resource
import com.weicools.kotlinlayout.widget.materialButton
import com.weicools.kotlinlayout.widget.parentId
import com.weicools.kotlinlayout.widget.textView
import com.weicools.kotlinlayout.widget.text_colorResource
import com.weicools.kotlinlayout.widget.text_resource
import com.weicools.kotlinlayout.widget.view
import com.weicools.kotlinlayout.widget.wrapContent

/**
 * @author weicools
 * @date 2021.04.23
 */
class MoreToolKtView : ConstraintLayout {
  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  init {
    initView()
  }

  private fun initView() {
    background_colorResource = R.color.white_primary

    val (icon, title, subtitle, action) = createRefs()

    imageView(icon) {
      layoutParams = constraintLayoutParams(44.dp, 44.dp) {
        leftMargin = 32.dp
        leftToLeft = parentId
        topToTop = parentId
        bottomToBottom = parentId
      }
      image_resource = R.drawable.ic_android_24dp
    }

    materialButton(action, R.style.MaterialTheme_MaterialButton) {
      layoutParams = constraintLayoutParams(0, 36.dp) {
        rightMargin = 32.dp
        rightToRight = parentId
        topToTop = parentId
        bottomToBottom = parentId
        matchConstraintPercentWidth = 0.2444f
      }
      textSize = 14f
      text_colorResource = R.color.white_primary
      text_resource = R.string.tool_action_button
    }

    textView(title) {
      layoutParams = constraintLayoutParams(0, wrapContent) {
        leftMargin = 14.dp
        rightMargin = 14.dp
        leftToRight = icon
        topToTop = parentId
        rightToLeft = action
        bottomToTop = subtitle
        verticalChainStyle = chainPacked
      }
      text_colorResource = R.color.black_87_transparent
      text_resource = R.string.tool_title
      textSize = 16f
    }

    textView(subtitle) {
      layoutParams = constraintLayoutParams(0, wrapContent) {
        leftMargin = 14.dp
        rightMargin = 14.dp
        topMargin = 4.dp
        leftToRight = icon
        topToBottom = title
        rightToLeft = action
        bottomToBottom = parentId
        verticalChainStyle = chainPacked
      }
      text_colorResource = R.color.black_54_transparent
      text_resource = R.string.tool_subtitle
      textSize = 12f
    }

    view {
      layoutParams = constraintLayoutParams(0, 1.dp) {
        leftMargin = 32.dp
        rightMargin = 32.dp
        leftToLeft = parentId
        rightToRight = parentId
        bottomToBottom = parentId
      }
      background_colorResource = R.color.colorAccent
    }
  }
}