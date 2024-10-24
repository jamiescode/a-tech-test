package com.a.technicaltest.detail.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.a.technicaltest.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(onGoBack: () -> Unit) {
    TopAppBar(
        title = { Text(text = stringResource(R.string.market_details_app_bar_title), color = Color.White) },
        navigationIcon = @Composable {
            IconButton(onClick = { onGoBack() }) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }
        },
        modifier = Modifier.statusBarsPadding(),
        colors =
            TopAppBarDefaults.topAppBarColors(
                containerColor = colorResource(R.color.purple_500),
                navigationIconContentColor = Color.White,
            ),
    )
}

@Preview
@Composable
fun AppBarPreview() {
    MaterialTheme {
        Column {
            AppBar {}
        }
    }
}
