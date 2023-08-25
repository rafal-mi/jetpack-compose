package com.example.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun StaticRow() {
    Row(
        Modifier
            // .padding(horizontal = 16.dp)
            // .horizontalScroll(rememberScrollState())
            .height(IntrinsicSize.Max)
            .fillMaxWidth()
            .background(Color(0xf6f6f6)),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        content = {
            StaticRowItem(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.33f)
                ,
                textCount = 1
            )
            StaticRowItem(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.67f)
                ,
                textCount = 2
            )

        },
    )
}

@Composable
fun StaticRowItem(modifier: Modifier = Modifier, textCount: Int) {
    Surface(
        modifier = modifier,
        color = Color(0xFF469597),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .padding(0.dp)
        ) {
            repeat(textCount) {
                Text(
                    text = "item $it",
                    color = Color.White,
                    modifier = Modifier.padding(
                        horizontal = 16.dp,
                        vertical = 4.dp
                    )
                )
            }

//            Spacer(modifier = Modifier.weight(1f))
//
//            Button(
//                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFddbeaa)), onClick = {
//                }) { Text(text = "Button") }
        }
    }
}

