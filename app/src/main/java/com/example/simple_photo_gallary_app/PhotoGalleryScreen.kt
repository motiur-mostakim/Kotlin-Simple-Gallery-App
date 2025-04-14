package com.example.simple_photo_gallary_app

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhotoGalleryScreen(modifier: Modifier = Modifier) {
    val photos = listOf(
        R.drawable.mostakim,
        R.drawable.mr_mostakim,
        R.drawable.mostakim__2_,
        R.drawable._717168054612,
        R.drawable._717168835045,
        R.drawable._717178397769,
        R.drawable._717178598591,
        R.drawable._717178778201,
        R.drawable._717178997445,
        R.drawable._717179165886,
        R.drawable._717265709613,
        R.drawable._717265837595,
        R.drawable._717265837595_1,
        R.drawable._717266188836,
        R.drawable._719141465579,
        R.drawable._719685094563,
        R.drawable.mostakim_image,
        R.drawable._730687267787,
        R.drawable._730687558394,
    )
    var index = remember {
        mutableStateOf(value = 0)
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Photo Gallery") },
                actions = {
                    Text(
                        text = "Showing ${index.value + 1} / ${photos.size}",
                        modifier = modifier.padding(8.dp)
                    )
                }
            )
        }
    ) {
        Column(
            modifier = modifier
                .padding(it)
                .fillMaxSize()
                .padding(8.dp)
        ) {
            Card(
                elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
                modifier = modifier.weight(1f)
            ) {
                Crossfade(
                    targetState = index.value,
                    label = "photo",
                    animationSpec = tween(durationMillis = 500)
                ) {
                    Image(
                        painter = painterResource(id = photos[it]),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = modifier.fillMaxSize()
                    )
                }
            }
            Surface(
                modifier = Modifier
                    .padding(8.dp)
                    .weight(0.2f)
                    .wrapContentSize(align = Alignment.Center)
            ) {
                Row {
                    OutlinedButton(
                        modifier = modifier.weight(1f),
                        enabled = index.value > 1,
                        onClick = {
                            index.value--
                        }) {
                        Text(text = "Previous")
                    }
                    Spacer(modifier = modifier.width(20.dp))
                    OutlinedButton(
                        modifier = modifier.weight(1f),
                        enabled = index.value < photos.size - 1,
                        onClick = {
                            index.value++
                        }) {
                        Text(text = "Next")
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun PhotoGalleryPreview() {
    PhotoGalleryScreen()
}