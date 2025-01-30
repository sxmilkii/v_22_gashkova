package com.example.gashkova_v_22


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class PersonalAreaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PersonalAreaScreen()
        }
    }
}

@Composable
fun PersonalAreaScreen() {
    Text(text = "Личный кабинет")
}