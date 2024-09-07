package com.example.CarApp1.screens.home

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.CarApp1.model.Cars
import com.example.CarApp1.model.getMovies
import com.example.CarApp1.navigation.MovieScreens
import com.example.CarApp1.widgets.MovieRow


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){

    Scaffold(
        topBar = { TopAppBar(
            title = { Text("Southern Luxury AutoSport") }
        )  },
        content = { padding ->
            Surface(
                modifier = Modifier.padding(padding),
            ) {
                MainContent(navController = navController)


            }
        }
    )

}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun MainContent(navController: NavController,
                movieList: List<Cars> = getMovies()
)  {
    Column(modifier= Modifier.padding(12.dp)){
        LazyColumn{
            items(items = movieList){

                MovieRow(movie = it){ movie ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")


                }

            }

        }

    }


}

@Composable
fun MovieRow(movie:String){
    Card(modifier = Modifier
        .padding(4.dp)
        .fillMaxWidth()
        .height(130.dp),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))){
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start){
            Surface(modifier = Modifier
                .padding(12.dp)
                .size(100.dp),
                shape = RectangleShape
            ){
                Icon(imageVector = Icons.Default.AccountBox,
                    contentDescription = "Car Images")

            }

            Text(text= movie)
        }

    }

}

