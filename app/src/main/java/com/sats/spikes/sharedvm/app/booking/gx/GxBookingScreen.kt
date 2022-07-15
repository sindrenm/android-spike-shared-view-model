package com.sats.spikes.sharedvm.app.booking.gx

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.bottomSheet
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.sats.spikes.sharedvm.app.booking.GxBookingViewModel
import com.sats.spikes.sharedvm.app.booking.gx.filters.GxBookingFiltersScreen

@OptIn(ExperimentalMaterialNavigationApi::class)
@Composable
fun GxBookingScreen(gxBookingViewModel: GxBookingViewModel) {
    val bottomSheetNavigator = rememberBottomSheetNavigator()
    val navController = rememberNavController(bottomSheetNavigator)

    LaunchedEffect(Unit) {
        if (gxBookingViewModel.openedGxSearch == null) {
            navController.navigate("/filters")
        }
    }

    ModalBottomSheetLayout(bottomSheetNavigator = bottomSheetNavigator) {
        NavHost(navController, startDestination = "/") {
            composable("/") {
                GxBookingResultsScreen(
                    gxBookingViewModel = gxBookingViewModel
                ) { navController.navigate("/filters") }
            }

            bottomSheet("/filters") {
                GxBookingFiltersScreen(
                    gxBookingViewModel = gxBookingViewModel,
                )
            }
        }
    }
}
