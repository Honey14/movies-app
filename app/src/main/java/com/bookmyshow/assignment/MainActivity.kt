package com.bookmyshow.assignment

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bookmyshow.core.ImageLoader
import com.bookmyshow.feature_one.FeatureOneActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var imageLoader: ImageLoader

    private var imageCta: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageCta = findViewById(R.id.image_cta)
        imageLoader.loadImage(
            imageUrl = "https://static.businessworld.in/article/article_extra_large_image/1609147522_O1aw88_BMS.jpg",
            imageView = requireNotNull(imageCta)
        )
//      a better approach would have been to use the new splash screen API launched in Android 12
//      https://developer.android.com/about/versions/12/features/splash-screen

        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
            navigateToFeatureOne()
        }

//       could not finish the splash, it would the main activity too
//        finish()
    }

    private fun navigateToFeatureOne() {
        startActivity(
            Intent(this, FeatureOneActivity::class.java)
        )
    }
}