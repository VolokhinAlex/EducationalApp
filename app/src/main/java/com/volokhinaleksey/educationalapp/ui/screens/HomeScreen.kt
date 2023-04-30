package com.volokhinaleksey.educationalapp.ui.screens

import android.os.CountDownTimer
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volokhinaleksey.educationalapp.R
import com.volokhinaleksey.educationalapp.models.ui.HomeworkDataUI
import com.volokhinaleksey.educationalapp.models.ui.ScheduleUI
import com.volokhinaleksey.educationalapp.ui.theme.LightCyan
import com.volokhinaleksey.educationalapp.ui.theme.LightGreen
import com.volokhinaleksey.educationalapp.ui.widgets.HomeWorkCard
import com.volokhinaleksey.educationalapp.viewmodel.HomeScreenViewModel
import org.koin.androidx.compose.koinViewModel
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Date
import kotlin.time.Duration
import kotlin.time.Duration.Companion.milliseconds


@Composable
fun HomeScreen(viewModel: HomeScreenViewModel = koinViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1C1D21))
            .padding(20.dp, 10.dp)
    ) {
        TopBar()

        HeroClock()

        viewModel.currentLesson.observeAsState().value?.let {
            Classes(it)
        }

        viewModel.data.observeAsState().value?.let {
            HomeWork(homeworkUI = it)
        }
    }
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 5.dp, bottom = 15.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Hi, Mike!", color = Color.White, fontSize = 20.sp)
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
                    imageVector = Icons.Default.Settings,
                    contentDescription = Icons.Default.Settings.name,
                    tint = Color.White
                )
            }
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    imageVector = Icons.Default.AccountCircle, contentDescription = "",
                    tint = Color.White
                )
            }
        }
    }
}

@Composable
fun HeroClock() {
    var remainingTime by remember {
        mutableStateOf(Duration.ZERO)
    }
    val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
    CountDownTimerExams(
        targetDate = LocalDate.parse("20230429", formatter).atStartOfDay(),
        onTimerStarted = {
            remainingTime = it
        })
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(20.dp))
            .background(Brush.linearGradient(listOf(LightGreen, LightCyan)))
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Are you ready for exams?",
            modifier = Modifier.padding(bottom = 20.dp),
            color = Color.White,
            fontWeight = FontWeight.Black
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(modifier = Modifier.padding(end = 5.dp)) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(9.dp))
                                .background(Color(0x11000000))
                                .padding(10.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = if (remainingTime.inWholeDays < 10) {
                                    "0"
                                } else {
                                    "${remainingTime.inWholeDays.toString()[0]}"
                                },
                                color = Color.White,
                                fontWeight = FontWeight.Black,
                                modifier = Modifier.padding(2.dp)
                            )
                        }
                    }
                    Box(modifier = Modifier.padding(end = 5.dp)) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(9.dp))
                                .background(Color(0x11000000))
                                .padding(10.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = if (remainingTime.inWholeDays < 10) {
                                    "${remainingTime.inWholeDays}"
                                } else {
                                    "${remainingTime.inWholeDays.toString()[1]}"
                                },
                                color = Color.White,
                                fontWeight = FontWeight.Black,
                                modifier = Modifier.padding(2.dp)
                            )
                        }
                    }
                }
                Text(
                    text = "Days",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(modifier = Modifier.padding(end = 5.dp)) {
                        Icon(
                            painter = painterResource(id = R.drawable.time_split),
                            contentDescription = "time_split",
                            tint = Color.White,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                    Box(modifier = Modifier.padding(end = 5.dp)) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(9.dp))
                                .background(Color(0x11000000))
                                .padding(10.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = if ((remainingTime.inWholeHours % 24) < 10) {
                                    "0"
                                } else {
                                    "${(remainingTime.inWholeHours % 24).toString()[0]}"
                                },
                                color = Color.White,
                                fontWeight = FontWeight.Black,
                                modifier = Modifier.padding(2.dp)
                            )
                        }
                    }
                    Box(modifier = Modifier.padding(end = 5.dp)) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(9.dp))
                                .background(Color(0x11000000))
                                .padding(10.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = if ((remainingTime.inWholeHours % 24) < 10) {
                                    "${remainingTime.inWholeHours % 24}"
                                } else {
                                    "${(remainingTime.inWholeHours % 24).toString()[1]}"
                                },
                                color = Color.White,
                                fontWeight = FontWeight.Black,
                                modifier = Modifier.padding(2.dp)
                            )
                        }
                    }
                }
                Text(
                    text = "Hours",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(modifier = Modifier.padding(end = 5.dp)) {
                        Icon(
                            painter = painterResource(id = R.drawable.time_split),
                            contentDescription = "time_split",
                            tint = Color.White,
                            modifier = Modifier
                                .size(18.dp)
                        )
                    }
                    Box(modifier = Modifier.padding(end = 5.dp)) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(9.dp))
                                .background(Color(0x11000000))
                                .padding(10.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = if ((remainingTime.inWholeMinutes % 60) < 10) "0" else {
                                    "${(remainingTime.inWholeMinutes % 60).toString()[0]}"
                                },
                                color = Color.White,
                                fontWeight = FontWeight.Black,
                                modifier = Modifier.padding(2.dp)
                            )
                        }
                    }
                    Box(modifier = Modifier.padding(end = 5.dp)) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(9.dp))
                                .background(Color(0x11000000))
                                .padding(10.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = if ((remainingTime.inWholeMinutes % 60) < 10) {
                                    "${(remainingTime.inWholeMinutes % 60)}"
                                } else {
                                    "${(remainingTime.inWholeMinutes % 60).toString()[1]}"
                                },
                                color = Color.White,
                                fontWeight = FontWeight.Black,
                                modifier = Modifier.padding(2.dp)
                            )
                        }
                    }
                }
                Text(
                    text = "Minutes",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(top = 10.dp)
                )
            }
        }
    }
}

@Composable
fun Classes(scheduleClass: ScheduleUI) {
    val context = LocalContext.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Classes", color = Color.White)
        Text(
            text = "6 classes today", color = Color(
                0xFF5F6065
            )
        )
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp, bottom = 20.dp)
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
                    Image(
                        painter = painterResource(id = scheduleClass.icon),
                        contentDescription = scheduleClass.lesson,
                        modifier = Modifier.rotate(-25f)
                    )
                }
                Column(modifier = Modifier.padding(start = 15.dp)) {
                    Text(
                        text = scheduleClass.lesson,
                        color = Color.White,
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            painter = painterResource(id = R.drawable.clock),
                            contentDescription = "clock",
                            modifier = Modifier
                                .size(16.dp)
                                .padding(end = 4.dp),
                            tint = Color(
                                0xFF5F6065
                            )
                        )
                        Text(
                            text = scheduleClass.lessonTime, fontSize = 14.sp, color = Color(
                                0xFF5F6065
                            )
                        )
                    }
                }
            }
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Row(
                    modifier = Modifier
                        .clip(
                            RoundedCornerShape(
                                topEnd = 20.dp,
                                bottomEnd = 20.dp
                            )
                        )
                        .clickable { openInSkype(context = context) }
                        .background(Color(0xFF4BCFFF))
                        .padding(0.dp, 25.dp)
                        .rotate(90f),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Open in", modifier = Modifier
                            .padding(top = 15.dp, bottom = 15.dp), fontSize = 14.sp,
                        color = Color.White
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.videocam),
                        contentDescription = "open in zoom",
                        tint = Color.White,
                        modifier = Modifier
                            .padding(3.dp)
                            .border(
                                width = 1.dp,
                                color = Color.White,
                                shape = RoundedCornerShape(50)
                            )
                            .padding(2.dp)
                    )
                }

            }
        }
    }
}

@Composable
fun HomeWork(homeworkUI: List<HomeworkDataUI>) {
    Text(text = "Homework", color = Color.White)

    LazyRow(modifier = Modifier.padding(top = 20.dp)) {
        itemsIndexed(homeworkUI) { _, item ->
            HomeWorkCard(
                homeworkDataUI = item, modifier = Modifier
                    .width(220.dp)
                    .padding(end = 10.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFF252830))
                    .padding(20.dp)
            ) {
                Image(
                    painter = painterResource(id = item.icon),
                    contentDescription = item.lesson
                )
            }
        }
    }
}

@Composable
fun CountDownTimerExams(
    targetDate: LocalDateTime,
    onTimerFinished: () -> Unit = {},
    onTimerStarted: (Duration) -> Unit
) {
    var remainingTime by remember {
        mutableStateOf(Duration.ZERO)
    }

    val startCalendar = Calendar.getInstance()
    startCalendar.time = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant())
    val endCalendar = Calendar.getInstance()
    endCalendar.time = Date.from(targetDate.atZone(ZoneId.systemDefault()).toInstant())

    LaunchedEffect(key1 = true) {
        object : CountDownTimer(endCalendar.timeInMillis - startCalendar.timeInMillis, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                remainingTime = millisUntilFinished.milliseconds
            }

            override fun onFinish() {
                onTimerFinished()
            }
        }.start()
    }
    onTimerStarted(remainingTime)
}


