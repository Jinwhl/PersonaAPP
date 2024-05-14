package com.example.personaapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.personaapp.ui.theme.PersonaAPPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PersonaAPPTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Column {
        AppTitle()

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)) {
            SelectMBTI(type = "intj")
            SelectMBTI(type = "intp")
            SelectMBTI(type = "entj")
            SelectMBTI(type = "entp")
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)) {
            SelectMBTI(type = "infj")
            SelectMBTI(type = "infp")
            SelectMBTI(type = "enfj")
            SelectMBTI(type = "enfp")
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)) {
            SelectMBTI(type = "istj")
            SelectMBTI(type = "isfj")
            SelectMBTI(type = "estj")
            SelectMBTI(type = "esfj")
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)) {
            SelectMBTI(type = "istp")
            SelectMBTI(type = "isfp")
            SelectMBTI(type = "estp")
            SelectMBTI(type = "esfp")
        }
    }
}

@Composable
fun AppTitle() {
    Text(
        text = "Persona APP",
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(top = 20.dp)
    )
}

@Composable
fun SelectMBTI(type:String) {
    val context = LocalContext.current

    TextButton(
        onClick = {
            val intent = Intent(context, TypeActivity::class.java)
            intent.putExtra("MBTI", type)
            context.startActivity(intent)
        }) {
        Text(text = type,
            fontSize = 20.sp)
    }
}

@Preview
@Composable
fun PreviewThisPage() {
    //MainScreen()
}