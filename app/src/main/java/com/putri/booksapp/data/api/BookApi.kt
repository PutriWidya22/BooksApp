package com.putri.booksapp.data.api

import com.putri.booksapp.data.model.BookModel
import retrofit2.Call
import retrofit2.http.GET

// interface BookApi yang berisi file json yaitu BookList.json
interface BookApi {
    @GET("BookList.json")
    fun getBooks(): Call<List<BookModel>>
}