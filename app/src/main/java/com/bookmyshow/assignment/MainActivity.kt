package com.bookmyshow.assignment

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bookmyshow.assignment.di.DaggerAppComponentProvider
import com.bookmyshow.core.ImageLoader
import com.bookmyshow.feature_one.FeatureOneActivity
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var imageLoader: ImageLoader

    private var imageCta: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerAppComponentProvider.getAppComponent().inject(mainActivity = this)

        imageCta = findViewById(R.id.image_cta)
        imageLoader.loadImage(
            imageUrl = "https://static.businessworld.in/article/article_extra_large_image/1609147522_O1aw88_BMS.jpg",
            imageView = requireNotNull(imageCta)
        )

        imageCta?.setOnClickListener {
            startActivity(
                Intent(this, FeatureOneActivity::class.java)
            )
        }
    }
}