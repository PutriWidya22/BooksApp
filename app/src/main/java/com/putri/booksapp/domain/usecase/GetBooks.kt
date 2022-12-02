package com.putri.booksapp.domain.usecase

import arrow.core.Either
import arrow.core.None
import com.putri.booksapp.data.api.BookApi
import com.putri.booksapp.data.error.Failure
import com.putri.booksapp.data.extensions.makeRequest
import com.putri.booksapp.data.model.BookModel

// pada class GetBooks, terdapat parameter dengan deklarasi variabel bookApi, lalu mengakses
// class BookModel.
// setelah itu menggambil data buku dengan menggunakan getBooks().
class GetBooks(private val bookApi: BookApi) : UseCase<List<BookModel>, None>() {
    override suspend fun run(params: None): Either<Failure, List<BookModel>> =
        bookApi.getBooks().makeRequest().map { it ?: emptyList() }
}
