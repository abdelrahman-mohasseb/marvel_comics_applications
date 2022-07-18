package com.example.applicationtestjetpackcompose.data.remote.dto

import com.example.applicationtestjetpackcompose.domain.model.Comic


/**
 * Data Transferable Object that represents all the details of one comic obtained from the server.
 */

data class ComicDto(
    val characters: CharactersDto,
    val creators: CreatorsDto,
    val dates: List<DateDto>,
    val description: String?,
    val diamondCode: String,
    val digitalId: Int,
    val ean: String,
    val events: EventsDto,
    val format: String,
    val id: Int,
    val images: List<ImageDto>,
    val isbn: String,
    val issn: String,
    val issueNumber: Int,
    val modified: String,
    val pageCount: Int,
    val prices: List<PriceDto>,
    val resourceURI: String,
    val series: SeriesDto,
    val stories: StoriesDto,
    val textObjects: List<TextObjectsDto>,
    val thumbnail: ThumbnailDto,
    val title: String,
    val upc: String,
    val urls: List<UrlDto>,
    val variantDescription: String,
    val variants: List<VariantDto>
)

