package com.sats.spikes.sharedvm.app.booking.models

sealed interface GxSearch {
    val id: String
    val name: String
}

data class RecentSearch(
    override val id: String,
    override val name: String,
) : GxSearch

data class SavedSearch(
    override val id: String,
    override val name: String,
) : GxSearch

val GxSearch.isSaved: Boolean get() = this is SavedSearch
val GxSearch.isRecent: Boolean get() = this is RecentSearch
