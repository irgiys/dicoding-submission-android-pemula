package com.irgiys.leaguechampions

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Champ(
    val name: String,
    val description: String,
    val thumbnail: Int,
    val quotes: String,
    val jumbo: Int,
) : Parcelable
