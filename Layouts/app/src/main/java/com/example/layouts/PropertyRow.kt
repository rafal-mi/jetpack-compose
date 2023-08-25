package com.example.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PropertyRow(
    key: String,
    value: String
) {
    Row(
        modifier = Modifier
            .height(80.dp)
            .background(Color(0xfff6f6f6))
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth(.3f)
                .fillMaxHeight()
                .padding(start = 12.dp, end = 12.dp)
                .background(Color(0xfff0f000)),


        ) {
            Text(
                text = key,
                modifier = Modifier
                    .background(Color(0xffa0a0a0))
            )
        }

        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth(.7f)
                .fillMaxHeight()
                .padding(start = 12.dp, end = 12.dp)
                .background(Color(0xfff0f000)),


            ) {
            Text(
                text = value,
                modifier = Modifier
                    .fillMaxWidth(0.7f)
                    .background(Color(0xfff0f0f0))
            )
        }
    }
}