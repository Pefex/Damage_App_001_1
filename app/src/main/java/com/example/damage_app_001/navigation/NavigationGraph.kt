package com.example.damage_app_001.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.damage_app_001.ui_elements.CreateAndShowLocalizationScreen
import com.example.damage_app_001.ui_elements.MAIN_SCREEN
import com.example.damage_app_001.ui_elements.MainViewModel
import com.example.damage_app_001.ui_elements.Mainscreen

@Composable
fun NavigationGraph(navHostController: NavHostController, viewModel: MainViewModel){
    NavHost(navController = navHostController, startDestination = MAIN_SCREEN) {
        composable(route = MAIN_SCREEN){
            Mainscreen(navHostController)
        }
        composable(route = com.example.damage_app_001.ui_elements.CREATE_AND_SHOW_LOCALIZATION_SCREEN){
            CreateAndShowLocalizationScreen(viewModel)
        }



    }
}