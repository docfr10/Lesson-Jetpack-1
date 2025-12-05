package com.example.lesson_jetpack_1

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import kotlinx.coroutines.delay

@Composable
fun Screen3() {
    // ЭТО МЫ ПОСМОТРИМ НА НЕКСТ ПАРЕ
    val startAnimation = remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation.value) 1f else 0f,
        animationSpec = tween(durationMillis = 5000)
    )

    LaunchedEffect(Unit) {
        startAnimation.value = true
    }
    // ЭТО МЫ ПОСМОТРИМ НА НЕКСТ ПАРЕ

    Box(
        modifier = Modifier.fillMaxSize() // Make sure the box fills the entire screen
    ) {
        Image(
            alpha = alphaAnim.value,
            painter = painterResource(id = R.drawable.icon4), // Replace with your image resource
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(), // Make the image fill the entire box
            contentScale = ContentScale.FillBounds // or ContentScale.FillBounds to stretch the image
        )
    }
}
