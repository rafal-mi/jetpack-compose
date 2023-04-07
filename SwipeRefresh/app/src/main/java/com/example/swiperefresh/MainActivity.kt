package com.example.swiperefresh

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.swiperefresh.ui.theme.SwipeRefreshTheme
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SwipeRefreshTheme {
                // ContentWithAccompanist()
                ContentMigrated()
            }
        }
    }
}

@Composable
fun ContentWithAccompanist() {
    val viewModel = viewModel<MainViewModel>()
    val isLoading by viewModel.isLoading.collectAsState()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = isLoading)

    SwipeRefresh(
        state = swipeRefreshState,
        onRefresh = viewModel::loadStuff
    ) {
        TheList()
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ContentMigrated() {
    val viewModel = viewModel<MainViewModel>()
    val isLoading by viewModel.isLoading.collectAsState()
    val pullRefreshState = rememberPullRefreshState(
        refreshing = isLoading,
        onRefresh = viewModel::loadStuff
    )

    Box(modifier = Modifier.pullRefresh(pullRefreshState)) {
        TheList()
        PullRefreshIndicator(
            modifier = Modifier.align(Alignment.TopCenter),
            refreshing = isLoading,
            state = pullRefreshState
        )
    }
}

@Composable
fun TheList() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(100) {
            Text(
                text = "Item $it",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(32.dp)
            )
        }
    }

}