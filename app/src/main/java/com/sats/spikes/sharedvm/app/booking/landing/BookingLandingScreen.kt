package com.sats.spikes.sharedvm.app.booking.landing

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sats.spikes.sharedvm.app.booking.models.RecentSearch
import com.sats.spikes.sharedvm.app.booking.models.SavedSearch

@Composable
fun BookingLandingScreen(
    startNewGxSearch: () -> Unit,
    openSavedSearch: (savedSearch: SavedSearch) -> Unit,
    openRecentSearch: (recentSearch: RecentSearch) -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
            .padding(horizontal = 56.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        OutlinedButton(onClick = startNewGxSearch, Modifier.fillMaxWidth()) {
            Text("New empty GX search")
        }

        Header("Saved searches", Modifier.fillMaxWidth())

        OutlinedButton(onClick = { openSavedSearch(savedSearch0) }, Modifier.fillMaxWidth()) {
            Text("Saved Search #1")
        }

        OutlinedButton(onClick = { openSavedSearch(savedSearch1) }, Modifier.fillMaxWidth()) {
            Text("Saved Search #2")
        }

        OutlinedButton(onClick = { openSavedSearch(savedSearch2) }, Modifier.fillMaxWidth()) {
            Text("Saved Search #3")
        }

        Header("Recent searches", Modifier.fillMaxWidth())

        OutlinedButton(onClick = { openRecentSearch(recentSearch0) }, Modifier.fillMaxWidth()) {
            Text("Recent Search #1")
        }

        OutlinedButton(onClick = { openRecentSearch(recentSearch1) }, Modifier.fillMaxWidth()) {
            Text("Recent Search #2")
        }

        OutlinedButton(onClick = { openRecentSearch(recentSearch2) }, Modifier.fillMaxWidth()) {
            Text("Recent Search #3")
        }
    }
}

@Composable
private fun Header(text: String, modifier: Modifier = Modifier) {
    Column(modifier) {
        Text(text = text, style = MaterialTheme.typography.subtitle1)

        Divider(Modifier.padding(top = 8.dp))
    }
}

val savedSearch0 = SavedSearch(id = "savedSearch0", name = "Saved Search 0")
val savedSearch1 = SavedSearch(id = "savedSearch1", name = "Saved Search 1")
val savedSearch2 = SavedSearch(id = "savedSearch2", name = "Saved Search 2")
val recentSearch0 = RecentSearch(id = "recentSearch0", name = "Recent Search 0")
val recentSearch1 = RecentSearch(id = "recentSearch1", name = "Recent Search 1")
val recentSearch2 = RecentSearch(id = "recentSearch2", name = "Recent Search 2")
