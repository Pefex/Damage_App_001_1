package com.example.damage_app_001

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.damage_app_001.data.PropertyDataBase
import com.example.damage_app_001.domain.PropertyRepository
import com.example.damage_app_001.navigation.NavigationGraph
import com.example.damage_app_001.ui_elements.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val db = Room
            .databaseBuilder(applicationContext, PropertyDataBase::class.java, "element-db")
            .build()
        // 2. Manual MainViewModel Creation
        val mainViewModel = MainViewModel(PropertyRepository(
            db.propertyDao(),
            db.componentDao(),
            db.stairsDao(),
            db.floorDao(),
            db.elementsDao(),
            db.buildingElementsDao()
        )

        )

        enableEdgeToEdge()
        setContent {
            NavigationGraph(navHostController = rememberNavController(), mainViewModel)

        }
    }
}

