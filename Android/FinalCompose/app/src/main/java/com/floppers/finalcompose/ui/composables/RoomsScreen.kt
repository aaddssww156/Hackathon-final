package com.floppers.finalcompose.ui.composables

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.floppers.finalcompose.data.RetrofitApi
import com.floppers.finalcompose.data.RetrofitHelper
import com.floppers.finalcompose.data.Rooms
import com.floppers.finalcompose.ui.theme.PrimaryMainDefault
import kotlinx.coroutines.*

@Composable
fun RoomsScreen(navController: NavController) {
    var awailableRoomsCount by remember { mutableStateOf(10)}

    //var roomsArray: MutableList<Rooms> = getRooms()
    //Log.d("Rooms", roomsArray[2].address.toString())

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "List of rooms",
        modifier = Modifier.padding(20.dp, 0.dp),
        fontSize = 24.sp)
        
        Spacer(modifier = Modifier.size(50.dp))
        
        for (i in 1..10) {
            PrintRooms(i, navController)
        }

    }
}

@Composable
fun PrintRooms(i: Int, navController: NavController) {
    Button(onClick = {
        navController.navigate(Screens.SmartScreen.route)
    },
    modifier = Modifier
        .fillMaxWidth()
        .size(60.dp)
        .padding(50.dp, 10.dp),
    colors = ButtonDefaults.buttonColors(backgroundColor = PrimaryMainDefault),
    shape = RoundedCornerShape(25.dp)) {
        Text(text = "Room №$i")
    }

}



@OptIn(DelicateCoroutinesApi::class)
fun getRooms(): MutableList<Rooms> {
    var RoomsArray: MutableList<Rooms> = mutableListOf()
    var RoomsArray2: MutableList<Rooms> = mutableListOf()
    val retrofitApi = RetrofitHelper.getInstance().create(RetrofitApi::class.java)
    val deffered = GlobalScope.async(Dispatchers.Main) {
        //withContext(Dispatchers.Main) {
            val res = retrofitApi.getRooms()
            for(x in res.body()!!) {
                RoomsArray.add(Rooms(x.address, x.capacity, x.isempty))
            }
        //}
    }

    return RoomsArray
}