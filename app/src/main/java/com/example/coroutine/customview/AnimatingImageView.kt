package com.example.coroutine.customview

import android.content.Context
import android.graphics.drawable.Animatable
import android.graphics.drawable.Animatable2
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.util.AttributeSet
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.widget.AppCompatImageView

class AnimatingImageView(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) :
    AppCompatImageView(context, attrs, defStyleAttr) {
    constructor(context: Context?,attrs: AttributeSet?) : this(context,attrs,0)


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val animatable1 = drawable as Animatable
        animatable1.start()
        val animatedVectorDrawable1 = animatable1 as AnimatedVectorDrawable
        val value = object : Animatable2.AnimationCallback() {
            override fun onAnimationEnd(drawable: Drawable?) {
                (drawable as Animatable).start()
            }
        }
        animatedVectorDrawable1.registerAnimationCallback(value)
    }

}