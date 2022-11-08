package com.ramanie.supportmultiplescreensizes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeFragment(){
    // we aren't putting this in a remember{} simply bc we need it to get updated whenever the composable is recomposed
    val windowInfo = rememberWindowInfo()
    // we're checking if the width of the screen is the smallest width, if that's the case then we're gonna stack the lists
    if (windowInfo.screenWidthInfo is WindowInfo.WindowType.Compact){
        LazyColumn(modifier = Modifier.fillMaxSize()){
            // first list
            items(10){
                Text(text = "Item $it", fontSize = 16.sp, modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color.LightGray
                    )
                    .padding(5.dp))
            }
            // second list
            items(10){
                Text(text = "Item $it", fontSize = 16.sp, modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        Color.DarkGray
                    )
                    .padding(5.dp))
            }
        }
    }
    // if the screen's width is greater than 600dp then we wanna place the lists side-by-side
    else{
        Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxSize()) {
            LazyColumn(modifier = Modifier.weight(1f).fillMaxHeight()){
                // first list
                items(10){
                    Text(text = "Item $it", fontSize = 16.sp, modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Color.LightGray
                        )
                        .padding(5.dp))
                }
            }
            LazyColumn(modifier = Modifier.weight(1f).fillMaxHeight()){
                // second list
                items(10){
                    Text(text = "Item $it", fontSize = 16.sp, modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Color.DarkGray
                        )
                        .padding(5.dp))
                }
            }
        }
    }

}