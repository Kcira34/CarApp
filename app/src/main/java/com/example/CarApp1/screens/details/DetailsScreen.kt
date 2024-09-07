package com.example.CarApp1.screens.details

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.CarApp1.model.Cars
import com.example.CarApp1.model.getMovies
import com.example.CarApp1.widgets.MovieRow


@ExperimentalAnimationApi
@Composable
fun DetailsScreen(navController: NavController,
                  movieId: String?) {
    val newMovieList = getMovies().filter { movie ->
        movie.id == movieId
    }

    Scaffold(
        topBar = { AddAppBar(navController) },
        content = { padding ->
            Surface(
                modifier = Modifier.padding(padding),
            ) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Lorem ipsum dolor sit amet...")

                Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top) {

                    MovieRow(movie = newMovieList.first())
                    Spacer(modifier = Modifier.height(8.dp))
                    Divider()
                    //Text(text = "")
                    HorizontalScrollableImageView(newMovieList)
                }


            }
        }
    )



}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddAppBar(navController: NavController) {
    TopAppBar(


        {
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(imageVector = Icons.Default.ArrowBack,
                    contentDescription ="Arrow Back",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    })
                Spacer(modifier = Modifier.width(100.dp))

                Text(text = "Vehicles Details")
            }
        }


    )

}

@Composable
private fun HorizontalScrollableImageView(newMovieList: List<Cars>) {
    LazyRow {
        items(newMovieList[0].images) { image ->
            Card(modifier = Modifier.padding(12.dp).size(240.dp)) {
                Image(painter = rememberImagePainter(data = image),
                    contentDescription = "Cars Poster")

            }
            }
        }
}
