package com.example.bottomnavigation.uitel

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
@Preview
fun NotificationScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Red),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(modifier = Modifier.padding(1.dp), elevation = 16.dp, shape = CircleShape) {
                Image(
                    modifier = Modifier.padding(25.dp),
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notification",
                    colorFilter = ColorFilter.lighting(Color.DarkGray, add = Color.DarkGray)
                )

            }
            Spacer(modifier = Modifier.padding(5.dp))
            Text(
                text = "Notification Screen",
                style = TextStyle(fontStyle = FontStyle.Normal, fontSize = 25.sp),
                color=Color.DarkGray
            )
        }

    }
}