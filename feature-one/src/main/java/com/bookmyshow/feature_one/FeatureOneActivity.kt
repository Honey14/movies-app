package com.bookmyshow.feature_one

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.bookmyshow.feature_one.di.FeatureOneDaggerProvider
import com.bookmyshow.feature_one.viewmodel.FeatureOneViewModel

class FeatureOneActivity : AppCompatActivity() {

    private val viewModel: FeatureOneViewModel by viewModels<FeatureOneViewModel>()
    private lateinit var binding: ActivityFeatureOneBinding
    private val listOfVenues
        get() = binding.listOfVenues


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFeatureOneBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}