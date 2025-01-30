package com.example.gashkova_v_22

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
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

    MainContent(
        login = login,
        onLoginChange = { login = it },
        password = password,
        onPasswordChange = { password = it }
    )
}
@Composable
fun MainContent(
    login: String,
    onLoginChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit
) {
    val context = LocalContext.current

    // Основная колонка
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Изображение
        Image(
            painter = painterResource(id = R.drawable.women),
            contentDescription = null,
            modifier = Modifier.height(186.dp).fillMaxWidth()
        )

        // Поле для логина
        TextField(
            value = login,
            onValueChange = onLoginChange,
            placeholder = { Text("Логин:") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .border(
                    BorderStroke(2.dp, Color(0xFFE30611)),
                    shape = RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
        )

        // Поле для пароля
        TextField(
            value = password,
            onValueChange = onPasswordChange,
            placeholder = { Text("Пароль:") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .border(
                    BorderStroke(2.dp, Color(0xFFE30611)),
                    shape = RoundedCornerShape(16.dp)
                )
                .clip(RoundedCornerShape(16.dp))
                .background(Color.White)
        )

        // Кнопка для авторизации
        Button(
            onClick = {
                // Переход на PersonalArea без передачи данных
                val intent = Intent(context, PersonalArea::class.java)
                context.startActivity(intent)
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE30611)),
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(vertical = 20.dp)
        ) {
            Text("Авторизоваться", fontSize = 16.sp, modifier = Modifier.padding(vertical = 12.dp))
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewMainScreen() {
    MainScreen()
}
