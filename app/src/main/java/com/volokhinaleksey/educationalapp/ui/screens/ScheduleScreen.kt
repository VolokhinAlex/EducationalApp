package com.volokhinaleksey.educationalapp.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volokhinaleksey.educationalapp.R
import com.volokhinaleksey.educationalapp.models.Step
import com.volokhinaleksey.educationalapp.ui.theme.LightCyan
import com.volokhinaleksey.educationalapp.ui.theme.LightGreen

@Composable
fun ScheduleScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.Start
    ) {
        ScheduleTopBar()
        ScheduleClasses()
    }
}

@Composable
fun ScheduleTopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "Classes",
                fontWeight = FontWeight.Black,
                color = Color.White,
                fontSize = 20.sp
            )
            Text(text = "Today, 1 June", color = Color.DarkGray, fontSize = 13.sp)
        }
        Row {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = Icons.Default.Search.name,
                    tint = Color.White
                )
            }
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Default.List,
                    contentDescription = Icons.Default.List.name,
                    tint = Color.White
                )
            }
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.home),
                    contentDescription = "dashboard",
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun ScheduleClasses() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 20.dp),
    ) {
        val currentStep = remember { mutableStateOf(0) }
        VerticalStepProgressBar(
            steps = listOf(
                Step(title = "8:00 - 8:45"),
                Step(title = "9:00 - 9:45"),
                Step(title = "10:00 - 11:35", isAdditionalLesson = true),
            ),
            currentStep = currentStep.value,
            modifier = Modifier.fillMaxSize(),
            stepTitle = {
                Text(
                    text = it.title,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 10.dp)
                )
            },
            stepContent = {
                if (!it.isAdditionalLesson) {
                    LessonCard(
                        isCurrentLesson = it.isCurrent,
                        icon = {
                            Image(
                                painter = painterResource(id = R.drawable.arrow_160075),
                                contentDescription = "History",
                                modifier = Modifier.rotate(-25f)
                            )
                        },
                        title = {
                            Text(
                                text = "History",
                                color = Color.White
                            )
                        },
                        description = {
                            Text(
                                text = "Teacher: Mrs Barros",
                                fontSize = 14.sp,
                                color = Color.Gray
                            )
                        }
                    )
                } else {
                    AdditionalLessonCard(
                        isCurrentLesson = it.isCurrent,
                        icon = {
                            Image(
                                painter = painterResource(id = R.drawable.book_148200),
                                contentDescription = "Literature"
                            )
                        },
                        title = {
                            Text(
                                text = "Physical Education", color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        },
                        teacher = {
                            Text(
                                text = "Teacher: Mrs Barros", color = Color.Gray,
                                fontWeight = FontWeight.Light
                            )
                        },
                        description = {
                            Text(
                                text = "Intensive preparation for The Junior World Championship in Los Angeles",
                                color = Color.White,
                                modifier = Modifier.padding(bottom = 20.dp)
                            )
                        }
                    )
                }
            }
        )
    }
}

@Composable
fun VerticalStepProgressBar(
    steps: List<Step>,
    currentStep: Int,
    modifier: Modifier = Modifier,
    stepTitle: @Composable (Step) -> Unit,
    stepContent: @Composable (Step) -> Unit
) {
    val color = Brush.linearGradient(
        listOf(
            LightGreen, LightCyan
        )
    )
    Box(modifier = modifier) {
        Box(
            modifier = Modifier.width(30.dp)
        ) {
            Divider(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(2.dp)
                    .align(Alignment.Center),
                color = Color(0x2C21A993),
                thickness = 2.dp
            )
        }
        LazyColumn(modifier = modifier) {
            itemsIndexed(steps) { index, item ->
                val stepSize = if (currentStep == index) 25.dp else 10.dp
                val innerCircleColor = if (currentStep == index) Brush.linearGradient(
                    listOf(
                        Color.White,
                        Color.White
                    )
                ) else color
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Box(
                        modifier = Modifier.width(30.dp)
                    ) {
                        Canvas(modifier = Modifier
                            .size(stepSize)
                            .align(Alignment.Center)
                            .border(
                                shape = CircleShape,
                                width = if (currentStep == index) 8.dp else 0.dp,
                                brush = color
                            ),
                            onDraw = {
                                drawCircle(brush = innerCircleColor)
                            }
                        )
                    }
                    stepTitle(item)
                }
                Column(
                    modifier = Modifier.padding(start = 30.dp)
                ) {
                    stepContent(item.copy(isCurrent = currentStep == index))
                }
            }
        }
    }
}

@Composable
fun LessonCard(
    isCurrentLesson: Boolean,
    icon: @Composable () -> Unit,
    title: @Composable () -> Unit,
    description: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 20.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFF252830))
    ) {
        Row {
            Row(
                modifier = Modifier.padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(40))
                        .background(Color(0xFF2F3138)),
                    contentAlignment = Alignment.Center
                ) {
                    icon()
                }
                Column(modifier = Modifier.padding(start = 15.dp)) {
                    title()
                    Box(modifier = Modifier.padding(bottom = 10.dp))
                    description()
                }
            }
            if (isCurrentLesson) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(
                            RoundedCornerShape(
                                topEnd = 20.dp,
                                bottomEnd = 20.dp
                            )
                        )
                        .height(90.dp)
                        .background(Color(0xFF4BCFFF))
                        .rotate(90f),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Open in",
                        fontSize = 11.sp,
                        color = Color.White
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.videocam),
                        contentDescription = "open in zoom",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(2.dp)
                            .border(
                                width = 1.dp,
                                color = Color.White,
                                shape = RoundedCornerShape(50)
                            )
                            .padding(1.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun AdditionalLessonCard(
    isCurrentLesson: Boolean,
    icon: @Composable () -> Unit,
    title: @Composable () -> Unit,
    teacher: @Composable () -> Unit,
    description: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 20.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Brush.linearGradient(listOf(LightGreen, LightCyan)))
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Row(modifier = Modifier.padding(bottom = 20.dp)) {
                Box(
                    modifier = Modifier
                        .size(50.dp)
                        .clip(RoundedCornerShape(40))
                        .background(Color(0xFF2F3138)),
                    contentAlignment = Alignment.Center
                ) {
                    icon()
                }
                Column(modifier = Modifier.padding(start = 15.dp)) {
                    title()
                    Box(modifier = Modifier.padding(bottom = 10.dp))
                    teacher()
                }
            }
            description()
            Box {
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(100))
                        .background(Color.Cyan)
                        .padding(5.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Face,
                        contentDescription = "",
                        modifier = Modifier.size(15.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .clip(RoundedCornerShape(100))
                        .background(Color.Yellow)
                        .padding(5.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Face,
                        contentDescription = "",
                        modifier = Modifier.size(15.dp)
                    )
                }
                Box(
                    modifier = Modifier
                        .padding(start = 20.dp)
                        .clip(RoundedCornerShape(100))
                        .background(Color.Green)
                        .padding(5.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Face,
                        contentDescription = "",
                        modifier = Modifier.size(15.dp)
                    )
                }
            }
        }
    }
}