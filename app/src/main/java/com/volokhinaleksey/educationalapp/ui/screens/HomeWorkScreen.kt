package com.volokhinaleksey.educationalapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volokhinaleksey.educationalapp.R
import com.volokhinaleksey.educationalapp.models.ui.HomeworkDataUI
import com.volokhinaleksey.educationalapp.ui.widgets.HomeWorkCard
import com.volokhinaleksey.educationalapp.viewmodel.HomeWorkScreenViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeWorkScreen(viewModel: HomeWorkScreenViewModel = koinViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HomeWorkTopBar()
        viewModel.data.observeAsState().value?.let {
            HomeWorkList(homeWorkList = it)
        }
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
            Text(
                text = "Today, 1 June", color = Color(
                    0xFF5F6065
                ), fontSize = 13.sp
            )
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
fun HomeWorkList(homeWorkList: List<HomeworkDataUI>) {
    LazyColumn(modifier = Modifier.padding(top = 20.dp)) {
        itemsIndexed(homeWorkList) { _, item ->
            HomeWorkCard(homeworkDataUI = item, modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFF252830))
                .padding(20.dp), icon = {
                Image(
                    painter = painterResource(id = item.icon),
                    contentDescription = item.lesson
                )
            })
        }
    }
}
