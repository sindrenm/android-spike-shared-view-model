package com.sats.spikes.sharedvm.app.booking.gx

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.sats.spikes.sharedvm.app.booking.GxBookingViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@Composable
fun GxBookingResultsScreen(
    gxBookingViewModel: GxBookingViewModel,
    openFilters: () -> Unit
) {
    Column(
        Modifier
            .fillMaxWidth()
            .wrapContentWidth()
            .statusBarsPadding()
            .padding(56.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("GX Booking Results Screen")

        OutlinedButton(onClick = openFilters) {
            Text("Open filters")
        }

        Divider()

        gxBookingViewModel.openedGxSearch?.let { gxSearch ->
            Text(gxSearch.toString())
        }
    }
}

@HiltViewModel
class GxBookingScreenViewModel @Inject constructor() : ViewModel()
