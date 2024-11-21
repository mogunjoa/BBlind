package com.mogun.bblind.data.source.remote.api

import com.mogun.bblind.data.model.dto.ContentDto
import com.mogun.bblind.data.model.dto.ContentResponse
import com.mogun.bblind.data.model.dto.ListResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ContentService {

    @GET("list")
    suspend fun getList() : ListResponse

    @POST("save")
    suspend fun saveItem(@Body contentDto: ContentDto): ContentResponse

    @POST("update")
    suspend fun updateItem(@Body contentDto: ContentDto): ContentResponse

    @POST("@{id}")
    suspend fun deleteItem(@Path("id") id: Int): ContentResponse
}