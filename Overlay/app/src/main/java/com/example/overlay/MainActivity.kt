package com.example.overlay

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.overlay.ui.theme.OverlayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            OverlayTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MainContent() {
    val context = LocalContext.current
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Button(
                modifier = Modifier
                    .align(Alignment.TopCenter),
                onClick = {
                    Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show()
                }
            ) {

            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize(),
                color = Color.Transparent

            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .size(40.dp)
                            .align(Alignment.Center)
                    )
                }
            }
        }
    }
}