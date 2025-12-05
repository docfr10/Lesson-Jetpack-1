package com.example.lesson_jetpack_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
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
                        // Screen1("String")

                        // Screen2()

                        // Screen3()

                        Screen4()
                    }
                }
            }
        }
    }
}