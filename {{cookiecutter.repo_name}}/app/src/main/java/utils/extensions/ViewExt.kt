package {{ cookiecutter.package_name }}.utils.extensions

import android.content.res.ColorStateList
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Build
import android.support.annotation.LayoutRes
import android.support.design.widget.TextInputLayout
import android.support.v4.content.ContextCompat
import android.support.v7.widget.CardView
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.EditText

fun ViewGroup.inflate(@LayoutRes resourceId: Int) =
        LayoutInflater.from(context).inflate(
                resourceId,
                this,
                false
        )

fun <T : ViewDataBinding?> ViewGroup.bindingInflate(@LayoutRes resourceId: Int) =
        DataBindingUtil.inflate<T>(
                LayoutInflater.from(context),
                resourceId,
                this,
                false
        )

inline fun ViewGroup.forEach(action: (view: View) -> Unit) {
    for (index in 0 until childCount) {
        action(getChildAt(index))
    }
}

fun TextInputLayout.disableHintAnimation() {
    isHintAnimationEnabled = false
}

fun EditText.clearBackground() {
    val paddingBottom = paddingBottom
    val paddingTop = paddingTop
    val paddingLeft = paddingLeft
    val paddingRight = paddingRight
    background = null
    setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom)
}


fun View.hide() {
    visibility = GONE
}

fun View.show() {
    visibility = VISIBLE
}