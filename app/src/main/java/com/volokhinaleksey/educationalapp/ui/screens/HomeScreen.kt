package com.volokhinaleksey.educationalapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volokhinaleksey.educationalapp.R
import com.volokhinaleksey.educationalapp.ui.theme.LightCyan
import com.volokhinaleksey.educationalapp.ui.theme.LightGreen

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF1C1D21))
            .padding(20.dp, 10.dp)
    ) {
        TopBar()

        HeroClock()

        Classes()

        HomeWork()
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
                                text = "0",
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
                                text = "9",
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
                    textAlign = TextAlign.Center
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
                                text = "2",
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
                                text = "3",
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
                    textAlign = TextAlign.Center
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
                                text = "5",
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
                                text = "9",
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
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun Classes() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Classes", color = Color.White)
        Text(text = "6 classes today", color = Color.Gray)
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
                        painter = painterResource(id = R.drawable.arrow_160075),
                        contentDescription = "History",
                        modifier = Modifier.rotate(-25f)
                    )
                }
                Column(modifier = Modifier.padding(start = 15.dp)) {
                    Text(
                        text = "History",
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
                            tint = Color.Gray
                        )
                        Text(text = "8:00 - 8:45", fontSize = 14.sp, color = Color.Gray)
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
fun HomeWork() {
    Text(text = "Homework", color = Color.White)

    LazyRow(modifier = Modifier.padding(top = 20.dp)) {
        items(5) {
            Column(
                modifier = Modifier
                    .width(220.dp)
                    .padding(end = 10.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .background(Color(0xFF252830))
                    .padding(20.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Literature",
                            color = Color.White,
                            modifier = Modifier.padding(bottom = 5.dp)
                        )
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Icon(
                                painter = painterResource(id = R.drawable.clock),
                                contentDescription = "time",
                                tint = Color(0xFFC44563),
                                modifier = Modifier
                                    .size(14.dp)
                                    .padding(end = 3.dp)
                            )
                            Text(
                                text = "2 days left",
                                color = Color(0xFFC44563),
                                fontSize = 14.sp
                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .size(50.dp)
                            .clip(RoundedCornerShape(40))
                            .background(Color(0xFF2F3138)),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.book_148200),
                            contentDescription = "Literature"
                        )
                    }
                }
                Text(
                    text = "Read scenes 1.1-1.12 of The Master and Margarita",
                    color = Color.White,
                    fontSize = 13.sp,
                    modifier = Modifier.padding(0.dp, 10.dp)
                )
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
                }
            }
        }
    }
}