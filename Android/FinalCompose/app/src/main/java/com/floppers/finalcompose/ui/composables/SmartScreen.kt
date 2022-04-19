package com.floppers.finalcompose.ui.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.floppers.finalcompose.ui.theme.PrimaryMainDefault
import com.floppers.finalcompose.R


@Composable
fun SmartScreen(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.SpaceEvenly) {
        Text(text = "Hello name!",
            modifier = Modifier.padding(20.dp, 0.dp),
            fontSize = 24.sp)
        Row() {
            Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .weight(1f)
                .padding(20.dp)
                .size(170.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryMainDefault),
            shape = RoundedCornerShape(25.dp)) {
                Icon(painter = painterResource(id = R.drawable.ic_baseline_music_note_24),
                    contentDescription = "music")
            }
            Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .weight(1f)
                .padding(20.dp)
                .size(170.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryMainDefault),
                shape = RoundedCornerShape(25.dp)) {
                Icon(painter = painterResource(id = R.drawable.ic_baseline_present_to_all_24),
                    contentDescription = "presentation")
            }
        }
        Row() {
            Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .weight(1f)
                .padding(20.dp)
                .size(170.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryMainDefault),
                shape = RoundedCornerShape(25.dp)) {
                Icon(painter = painterResource(id = R.drawable.ic_baseline_waves_24),
                    contentDescription = "cooler")
            }

            Button(onClick = { /*TODO*/ },
            modifier = Modifier
                .weight(1f)
                .padding(20.dp)
                .size(170.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryMainDefault),
                shape = RoundedCornerShape(25.dp)) {
                Icon(painter = painterResource(id = R.drawable.ic_baseline_wb_sunny_24),
                    contentDescription = "light")
            }
        }
        Spacer(modifier = Modifier.size(50.dp))
        
    }
}