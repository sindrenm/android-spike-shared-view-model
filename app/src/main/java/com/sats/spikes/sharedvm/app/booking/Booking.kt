package com.sats.spikes.sharedvm.app.booking

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sats.spikes.sharedvm.app.booking.gx.GxBookingScreen
import com.sats.spikes.sharedvm.app.booking.landing.BookingLandingScreen
import com.sats.spikes.sharedvm.app.booking.models.GxSearch
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@Composable
fun Booking() {
    val navController = rememberNavController()

    val gxBookingViewModel: GxBookingViewModel = hiltViewModel()

    Scaffold { contentPadding ->
        NavHost(navController, startDestination = "/", Modifier.padding(contentPadding)) {
            composable("/") {
                BookingLandingScreen(
                    startNewGxSearch = {
                        gxBookingViewModel.onEmptySearchSelected()
                        navController.navigate("/gx")
                    },
                    openSavedSearch = {
                        gxBookingViewModel.onSearchSelected(it)
                        navController.navigate("/gx")
                    },
                    openRecentSearch = {
                        gxBookingViewModel.onSearchSelected(it)
                        navController.navigate("/gx")
                    },
                )
            }

            composable("/gx") {
                GxBookingScreen(gxBookingViewModel)
            }
        }
    }
}

@HiltViewModel
class GxBookingViewModel @Inject constructor() : ViewModel() {
    var openedGxSearch: GxSearch? by mutableStateOf(null)
        private set

    fun onEmptySearchSelected() {
        openedGxSearch = null
    }

    fun onSearchSelected(gxSearch: GxSearch) {
        openedGxSearch = gxSearch
    }
}
