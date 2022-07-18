package com.example.applicationtestjetpackcompose.data.mapper

import com.example.applicationtestjetpackcompose.data.local.entity.ComicEntity
import com.example.applicationtestjetpackcompose.data.remote.dto.*
import com.example.applicationtestjetpackcompose.domain.model.Comic
import com.example.applicationtestjetpackcompose.domain.model.Creator
import com.example.applicationtestjetpackcompose.domain.model.Date
import com.example.applicationtestjetpackcompose.domain.model.MarvelApiResponse


fun ComicEntity.toComic(): Comic {
        return Comic(
            characters = characters,
            creators = creators,
            dates = dates,
            description = description,
            images = images,
            issueNumber = issueNumber,
            pageCount = pageCount,
            prices = prices,
            series = series,
            thumbnail = thumbnail,
            title = title,
            isFavorite = isFavorite
        )
    }

fun Comic.toComicEntity(): ComicEntity {
    return ComicEntity(
        characters = characters,
        creators = creators,
        dates = dates,
        description = description,
        images = images,
        issueNumber = issueNumber,
        pageCount = pageCount,
        prices = prices,
        series = series,
        thumbnail = thumbnail,
        title = title,
        isFavorite = isFavorite
    )
}



    /// function to get the data that will represent the comic model in the domain layer to contain all the details of the comic we need in the UI
    fun ComicDto.toComic():Comic{
        return Comic(
            /// function [.map] is used to get transform our imageDto to a string that will represent the path of the image
            images = images.map { it.path },
            characters = characters.items.map { it.name },
            creators = creators.items.map { it.toCreator() },
            dates = dates.map { it.toDate() },
            description = description,
            issueNumber = issueNumber,
            pageCount = pageCount,
            prices = prices.map { it.price },
            series = series.name,
            thumbnail = thumbnail.path,
            title = title,
            isFavorite = false,
        )
    }



fun MarvelApiResponseDto.toMarvelApiResponse() : MarvelApiResponse {
    return MarvelApiResponse(
        code = code,
        data = data.results.map { it.toComic() },
        status = status
    )

}


    fun DateDto.toDate(): Date {
        return Date(
            date = date,
            type = type
        )
    }


fun ItemDto.toCreator() : Creator {

    return Creator(
        name = name,
        role = role
    )
}


