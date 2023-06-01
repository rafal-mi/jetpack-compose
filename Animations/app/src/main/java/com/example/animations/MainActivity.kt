package com.example.animations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import com.example.animations.animate.AnimatedVisibilityContent
import com.example.animations.animate.AnimatedVisibilityContentV2
import com.example.animations.ui.theme.AnimationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimationsTheme {
                Surface() {
                    AnimatedVisibilityContentV2()
                }
            }
        }
    }
}

