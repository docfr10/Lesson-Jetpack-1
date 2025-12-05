package com.example.lesson_jetpack_1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource

@Composable
fun Screen4() {
    // Динамический список
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Один элемент
        item {
            Image(painter = painterResource(R.drawable.icon), contentDescription = null)
        }

        // Несколько элементов
        items(10) {
            Image(painter = painterResource(R.drawable.icon2), contentDescription = null)
        }

        // Несколько элементов в виде списка
        items(listOf("Пример1", "Прммер 2")) {
            Text(it)
        }
    }
}