package com.bookmyshow.common_ui.imageloader

import android.content.Context
import android.widget.ImageView
import com.squareup.picasso.Picasso

class ImageLoaderImpl constructor(
    private val context: Context
) : com.bookmyshow.core.ImageLoader {

    private var picasso: Picasso = Picasso
        .Builder(context)
        .build()

    override fun cacheImage(imageUrl: String) {
        picasso.load(imageUrl)
            .fetch()
    }

    override fun loadImage(
        imageUrl: String,
        imageView: ImageView
    ) {
        picasso
            .load(imageUrl)
            .into(imageView)
    }
}