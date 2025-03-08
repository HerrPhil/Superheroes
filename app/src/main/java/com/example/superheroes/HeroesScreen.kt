package com.example.superheroes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.Hero
import com.example.superheroes.model.HeroesRepository
import com.example.superheroes.ui.theme.Shapes
import com.example.superheroes.ui.theme.SuperheroesTheme

@Composable
fun HeroItems(
    heroes: List<Hero>,
    contentPadding: PaddingValues = PaddingValues(0.dp)
) {

    LazyColumn(
        contentPadding = contentPadding
    ) {
        items(heroes) {
            HeroItem(
                hero = it,
                modifier = Modifier
                    .padding(
                        horizontal = dimensionResource(R.dimen.padding_medium),
                        vertical = dimensionResource(R.dimen.padding_small)
                    )
            )
        }
    }

}

@Composable
fun HeroItem(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(R.dimen.card_elevation)
        )
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
                .sizeIn(minHeight = dimensionResource(R.dimen.list_item_height))
        ) {
            HeroListItem(
                hero,
                modifier = Modifier
                    .weight(1f)
            )
            Spacer(Modifier.width(dimensionResource(R.dimen.padding_medium)))
            HeroImage(
                hero, modifier = Modifier
                    .clip(shape = Shapes.small)
                    .size(dimensionResource(R.dimen.image_size))
            )
        }

    }

}

@Composable
fun HeroListItem(hero: Hero, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
    ) {
        HeroName(hero)
        HeroDescription(hero)
    }

}

@Composable
fun HeroName(hero: Hero) {
    Text(
        text = stringResource(hero.nameRes),
        style = MaterialTheme.typography.displaySmall
    )
}

@Composable
fun HeroDescription(hero: Hero) {
    Text(
        text = stringResource(hero.descriptionRes),
        style = MaterialTheme.typography.bodyLarge
    )
}

@Composable
fun HeroImage(hero: Hero, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        Image(
            contentScale = ContentScale.FillWidth,
            painter = painterResource(hero.imageRes),
            alignment = Alignment.TopCenter,
            contentDescription = stringResource(hero.nameRes),
        )
    }
}

@Preview
@Composable
fun HeroItemsPreview() {
    SuperheroesTheme(darkTheme = false) {
        HeroItem(HeroesRepository.heroes[0])
    }
}
