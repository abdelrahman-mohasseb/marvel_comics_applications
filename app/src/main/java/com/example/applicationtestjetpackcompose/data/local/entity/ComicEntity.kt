package com.example.applicationtestjetpackcompose.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.applicationtestjetpackcompose.domain.model.Comic
import com.example.applicationtestjetpackcompose.domain.model.Creator
import com.example.applicationtestjetpackcompose.domain.model.Date

/**
 * Data class that represents all the details of the comic saved in the database when choosing it as favorite from the list.
 */
@Entity (tableName = "comics_table")
data class ComicEntity(
    val characters: List<String>,
    val creators: List<Creator>,
    val dates: List<Date>,
    val description: String?,
    @PrimaryKey
    val id: Int? = null,
    val images: List<String>,
    val issueNumber: Int,
    val pageCount: Int,
    val prices: List<Int>,
    val series: String,
    val thumbnail: String,
    val title: String,
    val isFavorite : Boolean,
)
