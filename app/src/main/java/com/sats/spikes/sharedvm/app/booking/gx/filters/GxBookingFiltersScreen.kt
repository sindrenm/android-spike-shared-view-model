package com.sats.spikes.sharedvm.app.booking.gx.filters

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sats.spikes.sharedvm.app.booking.GxBookingViewModel

@Composable
fun GxBookingFiltersScreen(gxBookingViewModel: GxBookingViewModel) {
    Column(
        Modifier
            .fillMaxWidth()
            .wrapContentWidth()
            .navigationBarsPadding()
            .padding(56.dp)
    ) {
        Text("GX Booking Filters Screen")

        Divider()

        gxBookingViewModel.openedGxSearch?.let { gxSearch ->
            Text(gxSearch.toString())
        }
    }
}

