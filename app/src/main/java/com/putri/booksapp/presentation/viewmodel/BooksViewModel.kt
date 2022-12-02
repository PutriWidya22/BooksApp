package com.putri.booksapp.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import arrow.core.None
import com.putri.booksapp.data.model.BookModel
import com.putri.booksapp.domain.usecase.GetBooks
import com.putri.booksapp.presentation.presentationmodel.BookPresentationModel

// membuat class BooksViewModel untuk menampilkan list buku dengan live data
// dan mengakses file BookPresentation.kt
class BooksViewModel(private val getBooks: GetBooks) : BaseViewModel() {
    private val books = MutableLiveData<List<BookPresentationModel>>()

    fun observeBooks(): LiveData<List<BookPresentationModel>> = books

    fun getBooks() = getBooks(None) { it.fold(::handleFailure, ::handleSuccess) }

    private fun handleSuccess(books: List<BookModel>) {
        this.books.value = books.map { BookPresentationModel(it.image) }
    }

    override fun cancelRequest() {
        getBooks.cancel()
    }
}