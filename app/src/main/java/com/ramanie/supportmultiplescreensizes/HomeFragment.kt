package com.ramanie.supportmultiplescreensizes

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HomeFragment(){
    LazyColumn(modifier = Modifier.fillMaxSize()){
        // first list
        items(10){
            Text(text = "Item $it", fontSize = 16.sp, modifier = Modifier.fillMaxWidth().background(
                Color.LightGray).padding(5.dp))
        }
        // second list
        items(10){
            Text(text = "Item $it", fontSize = 16.sp, modifier = Modifier.fillMaxWidth().background(
                Color.DarkGray).padding(5.dp))
        }
    }
}