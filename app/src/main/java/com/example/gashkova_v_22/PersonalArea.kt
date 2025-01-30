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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview

class PersonalArea : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCallScreen(username = "Ваше Имя")
        }
    }
}

@Composable
fun BusinessCallScreen(username: String) {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        // Верхняя строка с иконками и заголовком
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.share), // Замените на ваш ресурс
                contentDescription = "Share Icon",
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = "Деловой звонок",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center
            )
            Image(
                painter = painterResource(id = R.drawable.settings), // Замените на ваш ресурс
                contentDescription = "Settings Icon",
                modifier = Modifier.size(24.dp)
            )
        }

        // Приветствие
        Text(
            text = "Добрый день, $username!",
            fontSize = 16.sp,
            color = Color(0xFFE30611),
            modifier = Modifier.padding(vertical = 8.dp)
        )

        // Серый прямоугольник с номером
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFF5F5F5)) // Светло-серый фон
                .padding(16.dp)
        ) {
            Column {
                Text(text = "Ваш деловой номер", fontSize = 14.sp)
                Text(text = "+7 (383) 200-00-00", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }

        // Два прямоугольника с минуточками
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Исходящие
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp) // Отступ между прямоугольниками
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFFF5F5F5)) // Светло-серый фон
                    .padding(16.dp)
            ) {
                Column {
                    Text(text = "Исходящие мин.", fontSize = 14.sp)
                    Text(text = "282 мин.", fontSize = 16.sp, fontWeight = FontWeight.Bold)
                }
            }

            // Входящие
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFFE30611)) // Красный фон
                    .padding(16.dp)
            ) {
                Column {
                    Text(text = "Входящие мин.", fontSize = 14.sp, color = Color.White)
                    Image(
                        painter = painterResource(id = R.drawable.iconn), // Замените на ваш ресурс

                        contentDescription = "Incoming Icon",
                        modifier = Modifier.size(48.dp) // Размер изображения
                    )
                }
            }
        }

        // Текст с обновлением
        Text(
            text = "Обновлено 22 декабря, в 11:20",
            fontSize = 14.sp,
            color = Color(0xFFE30611),
            modifier = Modifier.padding(vertical = 8.dp)
        )

        // Кнопка
        Button(
            onClick = { /* Ваш код обработки клика */ },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .clip(RoundedCornerShape(16.dp)),
            colors = ButtonDefaults.buttonColors(Color(0xFFE30611)) // Красный фон кнопки
        ) {
            Text(text = "Изменить данные на сайте", color = Color.White)
        }
    }
}

// Предпросмотр для визуализации в Android Studio
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCallScreen(username = "Ваше Имя")
}
