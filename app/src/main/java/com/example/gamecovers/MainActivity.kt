package com.example.gamecovers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.gamecovers.repositories.GameRepository
import com.example.gamecovers.ui.theme.GameCoversTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GameCoversTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFC3B2C3)
                ) {
                    GameGallery()
                }
            }
        }
    }
}

@Composable
fun GameCover(imageLink: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        AsyncImage(
            model = imageLink,
            contentDescription = null,
            placeholder = painterResource(id = R.drawable.sampleboxart),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun GameInfo(title: String, developer: String, releaseDate: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(text = title)
        Text(text = "$developer - $releaseDate")
    }
}

@Composable
fun NavButtons(onBackPress: () -> Unit, onNextPress: () -> Unit, modifier: Modifier = Modifier) {
    Row {
        Button(
            onClick = onBackPress,
            colors = ButtonDefaults.buttonColors(Color(0xFF2C002E), Color.White)
        ) {
            Text(text = "Back")
        }
        Button(
            onClick = onNextPress,
            colors = ButtonDefaults.buttonColors(Color(0xFF5E3361), Color.White)
        ) {
            Text(text = "Next")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GameGallery() {
    val lastGameId = GameRepository.getLastId()
    var currentId by remember { mutableStateOf(1L) }
    val increaseValue: () -> Unit = { if (currentId < lastGameId) currentId++ else currentId = 1L }
    val decreaseValue: () -> Unit = { if (currentId > 1L) currentId-- else currentId = lastGameId }

    val game = GameRepository.getById(currentId)

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Game Gallery",
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            },
            colors = TopAppBarDefaults.mediumTopAppBarColors(Color(0xFF37013A))
        )
    }) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            GameCover(game.permalink, modifier = Modifier.weight(6f))
            GameInfo(game.name, game.developer, game.releaseDate, modifier = Modifier.weight(1f))
            NavButtons(decreaseValue, increaseValue, modifier = Modifier.weight(2f))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GameGalleryPreview() {
    GameCoversTheme {
        GameGallery()
    }
}
