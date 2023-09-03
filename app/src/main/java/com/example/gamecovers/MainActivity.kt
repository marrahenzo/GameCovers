package com.example.gamecovers

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
                    color = MaterialTheme.colorScheme.background
                ) {
                    GameGallery()
                }
            }
        }
    }
}

@Composable
fun GameCover(imageLink: String) {
    AsyncImage(model = imageLink, contentDescription = null)
}

@Composable
fun GameInfo(title: String, developer: String, releaseDate: String) {
    Column {
        Text(text = title)
        Text(text = "$developer - $releaseDate")
    }
}

@Composable
fun NavButtons(onBackPress: () -> Unit, onNextPress: () -> Unit) {
    Row {
        Button(onClick = onBackPress) {
            Text(text = "Back")
        }
        Button(onClick = onNextPress) {
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

    Scaffold(topBar = { Text(text = "Game Gallery") }) {
        Column(modifier = Modifier.padding(it)) {
            GameCover(game.permalink)
            GameInfo(game.name, game.developer, game.releaseDate)
            NavButtons(decreaseValue, increaseValue)
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
