package com.example.lesson_jetpack_1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Screen2() {
    // Контейнер Row, располагает элементы по горизонтали
    Row(
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.Bottom,
        modifier = Modifier
            .background(Color.Gray)
            .fillMaxHeight()
    ) {
        Text("Пример 1")
        Text("Пример 2")
        Text("Пример 3")

        // "Ленивая инициализация"
        var textField by remember { mutableStateOf("") }

        // Второй вариант поля для ввода текста
        OutlinedTextField(
            value = textField,
            onValueChange = { textField = it },
            label = { Text("Введите текст") }
        )
    }
}

@Composable
// Аннотация Preview нужна для просмотра экрана в режиме дизайна

// Принято создавать отдельную функцию с данной аннотацией и из нее вызывать необходимую
// для просмотра функцию, так как при наличии входных параметров @Preview работать не будет
@Preview(showSystemUi = true, showBackground = true)
fun Screen2Preview() {
    Screen2()
}
