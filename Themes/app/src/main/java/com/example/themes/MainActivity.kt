package com.example.themes

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.themes.App.Companion.TAG
import com.example.themes.ui.theme.ThemesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ThemesTheme {
                AppScaffold()
            }
        }
    }
}

@Composable
fun AppScaffold() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Top Bar"
                    )
                }
            )
        }
    ) { paddingValues ->
        Log.i(TAG, "Padding values are $paddingValues")

        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Text(text = "Content")
        }
    }
}