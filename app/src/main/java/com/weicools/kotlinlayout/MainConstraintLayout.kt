package com.weicools.kotlinlayout

import android.content.Context
import android.text.InputType
import android.text.TextUtils
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.weicools.kotlinlayout.dsl.*

class MainConstraintLayout : ConstraintLayout {
  constructor(context: Context) : super(context)
  constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
  constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  private val map = ViewIdMap()

  private fun toId(id: String) = map.getViewId(id)

  init {
    ImageView {
      id = R.id.ivHeader
      Layout_width = 0
      Layout_height = 0
      MarginBottom = 16.dp
      Src = R.drawable.singapore
      BottomToBottom = R.id.ivFavorite
      TopToTop = parentId
      AlignHorizontalOf = parentId
      HorizontalBias = 1.0f
      VerticalBias = 0.0f
      scaleType = scaleCenterCrop
    }

    ImageView {
      id = R.id.ivFavorite
      Layout_width = 36.dp
      Layout_height = 36.dp
      MarginEnd = 16.dp
      MarginBottom = 16.dp
      Background = R.drawable.info_background
      Padding = 5.dp
      Src = R.drawable.ic_star
      AlignVerticalOf = parentId
      EndToEnd = parentId
      VerticalBias = 0.19f
    }

    TextView {
      id = R.id.tvTitle
      Layout_width = wrapContent
      Layout_height = wrapContent
      MarginStart = 16.dp
      MarginTop = 16.dp
      textRes = R.string.singapore
      textSizeDp = 24f
      StartToStart = parentId
      TopToBottom = R.id.ivHeader
    }

    EditText {
      id = R.id.etCameraType
      Layout_width = 0
      Layout_height = wrapContent
      MarginTop = 8.dp
      textEms = 10
      textRes = R.string.camera_value
      AlignHorizontalOf = R.id.etSettings
      TopToBottom = R.id.tvTitle
      inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
    }

    TextView {
      id = R.id.tvCameraLabel
      Layout_width = wrapContent
      Layout_height = wrapContent
      MarginStart = 16.dp
      textRes = R.string.camera
      BaselineToBaseline = R.id.etCameraType
      StartToStart = parentId
      labelFor = R.id.etCameraType
    }

    TextView {
      id = R.id.tvSettingLabel
      Layout_width = wrapContent
      Layout_height = wrapContent
      MarginStart = 16.dp
      textRes = R.string.settings
      BaselineToBaseline = R.id.etSettings
      StartToStart = parentId
      labelFor = R.id.etSettings
    }

    EditText {
      id = R.id.etSettings
      Layout_width = 0
      Layout_height = wrapContent
      MarginStart = 6.dp
      MarginTop = 8.dp
      textEms = 10
      textRes = R.string.camera_settings
      StartToEnd = R.id.tvSettingLabel
      EndToEnd = R.id.tvDescription
      TopToBottom = R.id.etCameraType
      inputType = InputType.TYPE_TEXT_VARIATION_PERSON_NAME
    }

    Button {
      id = R.id.btnUpload
      Layout_width = wrapContent
      Layout_height = wrapContent
      MarginEnd = 16.dp
      MarginBottom = 16.dp
      textRes = R.string.upload
      BottomToBottom = parentId
      EndToEnd = parentId
    }

    Button {
      id = R.id.btnDiscard
      Layout_width = wrapContent
      Layout_height = wrapContent
      MarginEnd = 8.dp
      textRes = R.string.discard
      BaselineToBaseline = R.id.btnUpload
      EndToStart = R.id.btnUpload
      elevation = 0f
    }

    TextView {
      id = R.id.tvDescription
      Layout_width = 0
      Layout_height = 0
      MarginStart = 16.dp
      MarginTop = 8.dp
      MarginEnd = 16.dp
      MarginBottom = 8.dp
      textRes = R.string.singapore_description
      textSize = 15f
      BottomToTop = R.id.btnDiscard
      TopToBottom = R.id.etSettings
      AlignHorizontalOf = parentId
      ellipsize = TextUtils.TruncateAt.END
      isVerticalFadingEdgeEnabled = true
    }
  }
}