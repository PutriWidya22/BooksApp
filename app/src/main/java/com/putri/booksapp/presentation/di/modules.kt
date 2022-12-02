package com.putri.booksapp.presentation.di

import com.putri.booksapp.data.api.BookApi
import com.putri.booksapp.domain.usecase.GetBooks
import com.putri.booksapp.presentation.adapter.BooksAdapter
import com.putri.booksapp.presentation.viewmodel.BooksViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
// pada modules.kt terdapat retrofit, pemanggilan adapter, dan viewmodel
val appModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(getProperty<String>("base_url"))
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single { get<Retrofit>().create(BookApi::class.java) }
    single { GetBooks(get()) }
    factory { BooksAdapter() }
    viewModel { BooksViewModel(get()) }
}