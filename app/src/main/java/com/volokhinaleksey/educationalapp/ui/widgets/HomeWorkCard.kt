package com.volokhinaleksey.educationalapp.ui.widgets

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.volokhinaleksey.educationalapp.R
import com.volokhinaleksey.educationalapp.models.ui.HomeworkDataUI

@Composable
fun HomeWorkCard(
    homeworkDataUI: HomeworkDataUI,
    modifier: Modifier,
    icon: @Composable () -> Unit
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = homeworkDataUI.lesson,
                    color = Color.White,
                    modifier = Modifier.padding(bottom = 5.dp)
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.clock),
                        contentDescription = "time",
                        tint = if (homeworkDataUI.timeComplete > 3) Color(
                            0xFF5F6065
                        ) else Color(0xFFC44563),
                        modifier = Modifier
                            .size(14.dp)
                            .padding(end = 3.dp)
                    )
                    Text(
                        text = if (homeworkDataUI.timeComplete > 1) "${homeworkDataUI.timeComplete} days left" else "${homeworkDataUI.timeComplete} day left",
                        color = if (homeworkDataUI.timeComplete > 3) Color(
                            0xFF5F6065
                        ) else Color(0xFFC44563),
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
                icon()
            }
        }
        Text(
            text = homeworkDataUI.description,
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