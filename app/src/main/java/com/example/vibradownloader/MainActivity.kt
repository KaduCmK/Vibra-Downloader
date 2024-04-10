package com.example.vibradownloader

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.vibradownloader.ui.theme.VibraDownloaderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VibraDownloaderTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeScreen("Android")
                }
            }
        }
    }
}

@Composable
fun HomeScreen(name: String, modifier: Modifier = Modifier) {

    var ytLink by remember { mutableStateOf("") }
    var uiState by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Link do video:", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier.height(32.dp))
        TextField(value = ytLink, onValueChange = { ytLink = it })
        Spacer(modifier.height(100.dp))
        Button(onClick = { /*TODO*/ }) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "Buscar",
                style = MaterialTheme.typography.bodyLarge)
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, name = "DarkMode")
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VibraDownloaderTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            HomeScreen("Android")
        }
    }
}