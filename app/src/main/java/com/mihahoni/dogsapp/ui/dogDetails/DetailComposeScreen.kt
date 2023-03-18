package com.mihahoni.dogsapp.ui.dogDetails

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mihahoni.dogsapp.R

@Composable
fun DetailScreen(breedImagesListState: MutableState<DogBreedDetailViewItem>) {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(16.dp, 0.dp)
        ) {
            Text(
                text = breedImagesListState.value.name,
                style = MaterialTheme.typography.headlineLarge,
                color = colorResource(
                    id = R.color.black
                ), modifier = Modifier.padding(0.dp, 16.dp)
            )

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                breedImagesListState.value.imageUrlList.forEach { item ->
                    item {
                        DogImageCardView(item)
                    }
                }
            }
        }
    }

}

@Composable
fun DogImageCardView(
    image: String
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 7.dp
        ),
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .height(180.dp)
            .width(140.dp)
    ) {
        AsyncImage(
            model = image,
            contentDescription = "",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

    }

}