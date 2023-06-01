package com.example.animations.animate

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.FiniteAnimationSpec
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.IntOffset


@Composable
fun AnimatedVisibilityContent() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        var isVisible by remember {
            mutableStateOf(false)
        }
        Button(
            onClick = {
                isVisible = !isVisible
            }
        ) {
            Text("Toggle")
        }
        AnimatedVisibility(
            visible = isVisible,
            enter = slideInHorizontally() + fadeIn(),
            modifier = Modifier.fillMaxWidth().weight(1f)
        ) {
            Box(
                modifier = Modifier.background(Color.Red)
            )
        }
    }
}

@Composable
fun AnimatedVisibilityContentV2() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        var isVisible by remember {
            mutableStateOf(true)
        }
        Button(
            onClick = {
                isVisible = !isVisible
            }
        ) {
            Text("Toggle")
        }
        val time = 3000
        val spec = tween<IntOffset>(time) as FiniteAnimationSpec<IntOffset>
        val specFl = tween<Float>(time) as FiniteAnimationSpec<Float>
        val enterTransition = slideInHorizontally(
            animationSpec = spec,
            initialOffsetX = { it },
        ) + fadeIn(specFl)
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            androidx.compose.animation.AnimatedVisibility(
                visible = isVisible,
                enter = enterTransition,
                exit = slideOutHorizontally(spec) + fadeOut(specFl),
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier.background(Color.Red)
                )
            }
            androidx.compose.animation.AnimatedVisibility(
                visible = !isVisible,
                enter = enterTransition,
                exit = slideOutHorizontally(spec) + fadeOut(specFl),
                modifier = Modifier.fillMaxSize()
            ) {
                Box(
                    modifier = Modifier.background(Color.Yellow)
                )
            }
        }
    }
}
