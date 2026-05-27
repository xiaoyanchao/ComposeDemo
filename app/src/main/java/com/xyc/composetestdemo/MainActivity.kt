package com.xyc.composetestdemo

import android.R
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onVisibilityChangedNode
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.xyc.composetestdemo.ui.theme.ComposeTestDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTestDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
                    SimpleWidgetColumn(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun SimpleWidgetColumn(modifier: Modifier = Modifier) {
    Column {
        Text(
            text = "this is text",
            color = Color.Red,
            fontSize = 26.sp,
            modifier = modifier)
        val context = LocalContext.current
        Button(onClick = {
            Toast.makeText(context, "This is Toast", Toast.LENGTH_SHORT).show()
        }) {
            Text(
                text = "This is Button",
                color = Color.White,
                fontSize = 26.sp
            )
        }
        TextField(
            value = "",
            onValueChange =  {  },
            placeholder = {
                Text(text = "请输入您的姓名")
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,// 输入框聚焦时背景色
                unfocusedContainerColor = Color.Black,// 输入框未聚焦时背景色
                disabledContainerColor = Color.Red,// 输入框禁用时背景色（可选）
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTestDemoTheme {
        Greeting("Android")
    }
}