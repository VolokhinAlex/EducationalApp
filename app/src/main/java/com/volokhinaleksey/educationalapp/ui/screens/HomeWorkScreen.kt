package com.volokhinaleksey.educationalapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volokhinaleksey.educationalapp.R

@Composable
fun HomeWorkScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HomeWorkTopBar()
        HomeWorkList()
    }
}

@Composable
fun HomeWorkTopBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = "Homework",
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
fun HomeWorkList() {
    LazyColumn(modifier = Modifier.padding(top = 20.dp)) {
        items(5) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
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