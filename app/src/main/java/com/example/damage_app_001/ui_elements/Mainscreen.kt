package com.example.damage_app_001.ui_elements

import android.annotation.SuppressLint
import android.widget.Button
import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.damage_app_001.R

@Composable
fun Mainscreen(navController: NavHostController) {
    MainLeyout(navController)
}
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainLeyout(navHostController: NavHostController) {

    var list = emptyList<Int>()
    Scaffold(
        contentColor = Color.White,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Home",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 1.dp)
                    )
                },
                navigationIcon = {


                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Favorite",
                                modifier = Modifier.size(40.dp),
                                tint = Color.White,
                            )

                        }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.app_blue)
                )
            )
        },

        bottomBar = {
            BottomAppBar {
                Box {
                    Button(onClick = { navHostController.navigate(
                        CREATE_AND_SHOW_LOCALIZATION_SCREEN)},
                        colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.app_blue)),
                        shape = RoundedCornerShape(25.dp),
                        modifier = Modifier
                            .padding(8.dp)
                            .fillMaxSize()
                            .heightIn(40.dp)) {
                        Row(horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically) {

                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "Favorite",
                                modifier = Modifier.size(40.dp),
                                tint = Color.White,
                            )

                            Spacer(modifier = Modifier.width(20.dp))

                            Text(text = "Liegenschaften",
                                fontSize = 20.sp)

                        }


                    }

                }

            }
        }



    ) {  contentPadding ->
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,

            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp, bottom = 100.dp)
        ) {
           Column (
               verticalArrangement = Arrangement.SpaceEvenly,
               modifier = Modifier
                   .fillMaxHeight()
               ){

               StartButton(Icons.Default.Menu, "Terminkalender")
               StartButton(Icons.Default.Menu, "Historie")
               StartButton(Icons.Default.Menu, "Qr-Code")

           }

            Column (
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxHeight()
               ){

                StartButton(Icons.Default.Menu, "Chat")
                StartButton(Icons.Default.Menu, "KOntakte")
                StartButton(Icons.Default.Settings, "Einstellungen")

            }
        }


    }
}

@Composable
fun StartButton(imageVector: ImageVector, text: String ) {
    Button(onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(containerColor = colorResource(R.color.app_blue)),
        shape = RoundedCornerShape(25.dp),
        modifier = Modifier
            .width(160.dp)
            .heightIn(100.dp)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            Icon(
                imageVector = imageVector,
                contentDescription = "Favorite",
                modifier = Modifier.size(40.dp),
                tint = Color.White,
            )

            Text(text = text)

        }


    }


}

@Preview
@Composable
fun previewLeyout() {
    val navController = rememberNavController()
    MainLeyout(navController)
}
