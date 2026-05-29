package com.xyc.composetestdemo

import android.R
import android.graphics.Bitmap
import android.os.Bundle
import android.text.Layout
import android.transition.CircularPropagation
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeCap.Companion
import androidx.compose.ui.layout.onVisibilityChangedNode
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.xyc.composetestdemo.ui.theme.ComposeTestDemoTheme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTestDemoTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
//                    Greeting(
//                        name = "Android",
//                        modifier = Modifier.padding(innerPadding)
//                    )
//                    SimpleWidgetColumn(modifier = Modifier.padding(innerPadding)) //垂直布局
//                    SimpleWidgetRow(modifier = Modifier.padding(innerPadding))//水平布局
                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.surface
                ) {
                    SimpleImage()
//                    HighLevelCompose()
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
    Column(
//        modifier = Modifier.fillMaxSize(), //充满父布局
//        horizontalAlignment = Alignment.CenterHorizontally, //居中
//        verticalArrangement = Arrangement.SpaceEvenly //平均分布view
        modifier = modifier.verticalScroll(rememberScrollState()) //垂直滚动
    ) {
        Text(
            text = "this is text",
            color = Color.Red,
            fontSize = 26.sp,
            modifier = modifier.align(Alignment.End)
        )
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
            value = "权威",
            onValueChange = { },
            placeholder = {
                Text(text = "请输入您的姓名")
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,// 输入框聚焦时背景色
                unfocusedContainerColor = Color.White,// 输入框未聚焦时背景色
            )
        )
        Image(
            painter = painterResource(id = com.xyc.composetestdemo.R.mipmap.ic_launcher_round),
            contentDescription = "这是个图标"
        )
        //加载bitmap形式图片
        val bitmap1: ImageBitmap =
            ImageBitmap.imageResource(id = com.xyc.composetestdemo.R.mipmap.ic_launcher_round)
        Image(
            bitmap = bitmap1,
            contentDescription = ""
        )
        //加载网络资源图片
        // AsyncImage是coil aar依赖
        AsyncImage(
            model = "https://img0.baidu.com/it/u=3591665277,2616537962&fm=253&app=138&f=JPEG?w=800&h=1333",
            contentDescription = ""
        )
        //圆形进度条
        CircularProgressIndicator(
            color = Color.Blue,
            strokeWidth = 3.dp
        )
        //长形进度条
        LinearProgressIndicator()
    }
}

@Composable
fun SimpleWidgetRow(modifier: Modifier) {
    Row(
//        modifier = Modifier.fillMaxSize(), //充满父布局
//        horizontalAlignment = Alignment.CenterHorizontally, //居中
//        verticalArrangement = Arrangement.SpaceEvenly //平均分布view
        modifier = modifier.horizontalScroll(rememberScrollState()) //垂直滚动
    ) {
        Text(
            text = "this is text",
            color = Color.Red,
            fontSize = 26.sp,
            modifier = modifier
        )
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
            value = "权威",
            onValueChange = { },
            placeholder = {
                Text(text = "请输入您的姓名")
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,// 输入框聚焦时背景色
                unfocusedContainerColor = Color.White,// 输入框未聚焦时背景色
            )
        )
        Image(
            painter = painterResource(id = com.xyc.composetestdemo.R.mipmap.ic_launcher_round),
            contentDescription = "这是个图标"
        )
        //加载bitmap形式图片
        val bitmap1: ImageBitmap =
            ImageBitmap.imageResource(id = com.xyc.composetestdemo.R.mipmap.ic_launcher_round)
        Image(
            bitmap = bitmap1,
            contentDescription = ""
        )
        //加载网络资源图片
        // AsyncImage是coil aar依赖
        AsyncImage(
            model = "https://img0.baidu.com/it/u=3591665277,2616537962&fm=253&app=138&f=JPEG?w=800&h=1333",
            contentDescription = ""
        )
        //圆形进度条
        CircularProgressIndicator(
            color = Color.Blue,
            strokeWidth = 3.dp
        )
        //长形进度条
        LinearProgressIndicator()
    }
}

/**
 * Modifier.wrapContentSize() //根据自身大小显示
 * align = Alignment.CenterStart //居中左对齐
 * border(3.dp, Color.Blue, CircleShape) //边框3dp 颜色蓝色
 * clip(CircleShape) //裁剪为圆形
 * rotate(180f) //旋转180度
 */
@Composable
fun SimpleImage() {
    Image(
        painter = painterResource(com.xyc.composetestdemo.R.mipmap.ic_launcher),
        contentDescription = "",
        modifier = Modifier
            .wrapContentSize()
            .background(Color.Gray)
            .padding(18.dp)//padding 在border之前 -》外边距
            .border(3.dp, Color.Blue, CircleShape)
//            .padding(18.dp) //padding 在border之后 -》内边距
            .clip(CircleShape)
    )
}

/**
 * clickable 增加点击事件
 * draggable 拖拽方法 Orientation.Horizontal 水平拖拽
 */
@Composable
fun HighLevelCompose() {
    val context = LocalContext.current
    var offsetX by remember { mutableStateOf(0f) }
    Box(
        modifier = Modifier
            .offset { IntOffset(offsetX.roundToInt(), 0) }
            .requiredSize(200.dp)
            .background(Color.Blue)
//            .wrapContentSize(align = Alignment.TopStart) //加上这个不能执行draggable函数
            .clickable {
                Toast.makeText(context, "Box is click", Toast.LENGTH_SHORT).show()
            }
            .draggable(
                orientation = Orientation.Horizontal,
                state = rememberDraggableState { delta ->
                    offsetX += delta
                }
            )
    )

//    Column(
//        modifier = Modifier
//            .requiredSize(200.dp)
//            .background(color = Color.Blue)
//            .verticalScroll(rememberScrollState())
//    ) {
//        repeat(10) {
//            Text(
//                text = "Item is $it",
//                color = Color.White,
//                fontSize = 26.sp
//            )
//        }
//    }
}

@Composable
fun TestCloumn() {
    Column(
    ) {
        Text(
            text = "测速",
            modifier = Modifier.align(Alignment.TopStart as Alignment.Horizontal)
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