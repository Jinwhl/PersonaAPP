package com.example.personaapp

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.personaapp.ui.theme.PersonaAPPTheme

class TypeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PersonaAPPTheme {
                SubScreen()
            }
        }
    }

    @Composable
    fun SubScreen() {
        Column {
            val context = LocalContext.current as? Activity
            val type = context?.intent?.getStringExtra("MBTI") ?: ""

            TextButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, end = 8.dp)
                    .align(Alignment.End),

                onClick = { context?.finish() }
            ) {
                Text(
                    text = "Close $type Page",
                    color = Color.Gray
                )
            }
            val mbtiDescription = when (type) {
                "entj" -> "통솔자, 항상 문제 해결 방법을 찾아내는 성격으로, 대담하고 상상력이 풍부하며 의지가 강력한 지도자입니다."
                "entp" -> "변론가, 지적 도전을 즐기는 영리하고 호기심이 많은 사색가입니다."
                "intj" -> "전략가, 모든 일에 대해 계획을 세우며 상상력이 풍부한 전략가입니다."
                "intp" -> "논리술사, 지식을 끝없이 갈망하는 혁신적인 발명가입니다."
                else -> "예외"
            }
            val imageId = when (type) {
                "entj" -> R.drawable.entj
                "entp" -> R.drawable.entp
                "intj" -> R.drawable.intj
                "intp" -> R.drawable.intp
                /*
                "entj" -> R.drawable.enfj
                "entp" -> R.drawable.enfp
                "intj" -> R.drawable.infj
                "intp" -> R.drawable.infp
                "entj" -> R.drawable.estj
                "entp" -> R.drawable.estp
                "intj" -> R.drawable.istj
                "intp" -> R.drawable.istp
                "entj" -> R.drawable.esfj
                "entp" -> R.drawable.esfp
                "intj" -> R.drawable.isfj
                "intp" -> R.drawable.isfp
                */
                else -> R.drawable.intj // 기본 이미지 설정
            }
            val image = painterResource(id = imageId)

            Image(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                painter = image,
                contentDescription = "$type Image",
                contentScale = ContentScale.Fit
            )
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                text = mbtiDescription,
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}