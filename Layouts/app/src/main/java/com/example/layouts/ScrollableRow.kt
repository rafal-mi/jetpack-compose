package com.example.layouts

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
fun ScrollableRow() {
    Row(
        Modifier
            .padding(horizontal = 16.dp)
            .horizontalScroll(rememberScrollState())
            .height(IntrinsicSize.Max),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        content = {
            repeat(4) {
                ScrollableRowItem(
                    modifier = Modifier
                        .fillMaxHeight(),
                    textCount = it.plus(1)
                )
            }
        },
    )
}

@Composable
fun ScrollableRowItem(modifier: Modifier = Modifier, textCount: Int) {
    Surface(
        modifier = modifier,
        color = Color(0xFF469597),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(16.dp)
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

            Spacer(modifier = Modifier.weight(1f))

            Button(
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFddbeaa)), onClick = {
                }) { Text(text = "Button") }
        }
    }
}
