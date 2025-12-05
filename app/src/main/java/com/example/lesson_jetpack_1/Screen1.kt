package com.example.lesson_jetpack_1

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Аннотация Composable объявляет о том, что в данной функции будет UI код на jetpack
@Composable
fun Screen1(string: String) {
    // Контейнер Column, располагает элементы по вертикали
    Column(
        verticalArrangement = Arrangement.spacedBy(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        // Параметр modifier отвечает за настройки элемента
        modifier = Modifier
            //.background(Color.Red)
            .fillMaxSize()
    ) {
        // Переменная, которая хранит состояние и автоматически его обновляет
        // Стандартный способ инициализации
        val textField = remember { mutableStateOf("") }

        val switch = remember { mutableStateOf(false) }

        // Текстовый элемент
        Text(text = "Hello, World!")

        // Кнопка
        Button(onClick = { Log.i("Button", "На меня нажали") }) {
            Text("Нажми на меня")
        }

        // Поле для ввода текста — на данный момент неактуальный
        TextField(
            value = textField.value,
            onValueChange = { textField.value = it },
            label = { Text("Enter text") },
            // Настройка текстового поля
            keyboardOptions = KeyboardOptions(
                // Ввода пароля
                keyboardType = KeyboardType.Password,
                // Действие при нажатии на enter на клавиатуре
                imeAction = ImeAction.Done
            )
        )

        // Кнопка с иконкой
        IconButton(
            modifier = Modifier.size(200.dp),
            onClick = {}) {
            if (switch.value) Image(
                painter = painterResource(R.drawable.icon),
                contentDescription = ""
            )
            else Image(
                painter = painterResource(R.drawable.icon2),
                contentDescription = ""
            )
        }

        // Иконка
        Icon(imageVector = Icons.Default.DateRange, contentDescription = "")

        // Переключатель
        Switch(checked = switch.value, onCheckedChange = { switch.value = it })

        // Ползунок
        val sliderPosition = remember { mutableFloatStateOf(15f) }

        Slider(
            value = sliderPosition.value, // Текущее значение ползунка
            onValueChange = {
                sliderPosition.value = it
            }, // Лямбда-функция, вызываемая при изменении значения ползунка
            steps = 10,
            valueRange = 0f..100f // Диапазон допустимых значений для ползунка
        )
    }
}

@Composable
// Аннотация Preview нужна для просмотра экрана в режиме дизайна

// Принято создавать отдельную функцию с данной аннотацией и из нее вызывать необходимую
// для просмотра функцию, так как при наличии входных параметров @Preview работать не будет
@Preview(showSystemUi = true, showBackground = true)
fun Screen1Preview() {
    Screen1("String")
}