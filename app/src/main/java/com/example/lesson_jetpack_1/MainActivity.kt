package com.example.lesson_jetpack_1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.lesson_jetpack_1.ui.theme.LessonJetpack1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            // Метод, который отвечает за вызов настроек темы приложения
            LessonJetpack1Theme {
                // Контейнер для задания "фундамента" интерфейса
                // Основная особенность в том, что контейнер воспринимает грани экрана
                // устройства при помощи лямбды "innerPadding"
                // и не позволяет элементам оказаться вне экрана
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        // Контейнер Column, располагает элементы по вертикали
                        Column(
                            verticalArrangement = Arrangement.spacedBy(50.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            // Параметр modifier отвечает за настройки элемента
                            modifier = Modifier
                                .background(Color.Red)
                                .fillMaxWidth()
                        ) {
                            // Переменная, которая хранит состояние и автоматически его обновляет
                            // Стандартный способ инициализации
                            val textField = remember { mutableStateOf("") }

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
                                label = { Text("Enter text") }
                            )
                        }

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
                }
            }
        }
    }
}