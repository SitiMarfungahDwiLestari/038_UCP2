package com.example.ucp2

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ucp2.data.SumberData.dosen
import com.example.ucp2.data.OrderUIState


enum class PengelolaHalaman {
    Home,
    Form,
    Summary
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormSkripsi(
    viewModel: OrderViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
    Scaffold(){
            innerPadding ->
        val uiState by viewModel.stateUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = PengelolaHalaman.Home.name,
            modifier = Modifier.padding(innerPadding)
        ){
            composable (route = PengelolaHalaman.Home.name){
                HalamanHome (
                    onNextButtonClicked = {
                        navController.navigate(PengelolaHalaman.Form.name)
                    }
                )
            }
            composable (route = PengelolaHalaman.Form.name){
                val context = LocalContext.current
                HalamanSatu (
                    dosen1 = dosen.map {id -> context.resources.getString(id)},
                    dosen2 = dosen.map {id -> context.resources.getString(id)},
                    onSelectionChanged = {viewModel.setDosen1(it)},
                    onNextButtonClicked = {
                        navController.navigate(PengelolaHalaman.Summary.name)
                    },
                )
            }

            composable(route = PengelolaHalaman.Summary.name){
                HalamanDua(orderUiState = uiState, onCancelButtonClicked = { cancelOrderAndNavigateToForm(navController)},
                )
            }
        }
    }
}

private fun cancelOrderAndNavigateToForm(
    navController: NavHostController
){
    navController.popBackStack(PengelolaHalaman.Form.name, inclusive = false)
}