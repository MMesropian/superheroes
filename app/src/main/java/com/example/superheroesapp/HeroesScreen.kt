package com.example.superheroesapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.HorizontalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroesapp.model.Hero
import com.example.superheroesapp.model.HeroesData
import com.example.superheroesapp.ui.theme.Shapes

@Composable
fun HeroesScreen(hero: Hero) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        shape = Shapes.medium
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .height(72.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color.Red)
                    .weight(1f)
            ) {
                Text(
                    text = stringResource(id = hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(id = hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(
                modifier = Modifier
                    .width(16.dp)
                    .background(color = Color.Green)
            )
            Box(
                modifier = Modifier
                    .clip(Shapes.small)

                    .size(72.dp)
                    .background(color = Color.Blue)
            ) {
                Image(
                    /*modifier = Modifier
                        .clip(Shapes.small)

                        .size(72.dp)
                        .background(color = Color.Blue),*/
                    painter = painterResource(id = hero.imageRes),
                    contentDescription = LocalContext.current.getString(hero.nameRes)
                )
            }
        }
    }
}

@Composable
fun HeroesList(innerPadding: PaddingValues) {
    LazyColumn(modifier = Modifier.fillMaxSize(), contentPadding = innerPadding) {
        items(HeroesData.heroes) {
            HeroesScreen(hero = it)
        }
    }
}

@Preview
@Composable
fun HeroesScreenPreview() {
    HeroesScreen(hero = HeroesData.heroes[0])
}

