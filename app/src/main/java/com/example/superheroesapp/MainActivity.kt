package com.example.superheroesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.superheroesapp.model.HeroesData
import com.example.superheroesapp.ui.theme.SuperHeroesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperHeroesAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    SuperHeroApp()
                }

            }
        }
    }
}

@Composable
fun SuperHeroApp() {
    Scaffold(
        topBar = { SuperHeroAppTopAppBar() },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        HeroesList(innerPadding)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroAppTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(title = {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.displayLarge
        )
    }
    )
}

@Preview(showBackground = true)
@Composable
fun SuperHeroAppPreview() {
    SuperHeroApp()
}