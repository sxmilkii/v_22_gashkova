package com.example.gashkova_v_22

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    var login by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showPersonalArea by remember { mutableStateOf(false) } // состояние для переключения экранов

    if (showPersonalArea) {
        PersonalAreaScreen(onBackPress = { showPersonalArea = false }) // Показываем PersonalArea
    } else {
        MainContent(
            login = login,
            onLoginChange = { login = it },
            password = password,
            onPasswordChange = { password = it },
            onLoginPress = { showPersonalArea = true } // При нажатии кнопки меняем состояние
        )
    }
}

@Composable
fun MainContent(
    login: String,
    onLoginChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    onLoginPress: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.women),
            contentDescription = null,
            modifier = Modifier.height(186.dp).fillMaxWidth()
        )

        TextField(
            value = login,
            onValueChange = onLoginChange,
            placeholder = { Text("Логин:") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .border(
                    BorderStroke(2.dp, Color(0x80BEBEBE)),
                    shape = RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFF5F5F5)),
        )

        TextField(
            value = password,
            onValueChange = onPasswordChange,
            placeholder = { Text("Пароль:") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .border(
                    BorderStroke(2.dp, Color(0x80BEBEBE)),
                    shape = RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFF5F5F5)),
        )

        Button(
            onClick = onLoginPress, // Переход на PersonalArea
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF5630)),
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(vertical = 20.dp)
        ) {
            Text("Авторизоваться", fontSize = 16.sp, modifier = Modifier.padding(vertical = 12.dp))
        }
    }
}

@Composable
fun PersonalAreaScreen(onBackPress: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Личный кабинет", style = MaterialTheme.typography.headlineLarge)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = onBackPress) {
            Text("Назад")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}