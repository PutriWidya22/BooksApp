package com.putri.booksapp.presentation.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.putri.booksapp.R
import com.putri.booksapp.presentation.adapter.BooksAdapter
import com.putri.booksapp.presentation.viewmodel.BooksViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import retrofit2.Response.error

// membuat class MainActivity atau kelas utama
class MainActivity : AppCompatActivity() {

    // deklarasi variabel booksViewModel sebagai viewmodel dan adapternya BooksAdapter
    private val booksViewModel: BooksViewModel by inject()
    private val adapter: BooksAdapter by inject()

    // untuk mengakses layout activity_main
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecycler()

        // pada bagian ini untuk menampilkan buku dengan adapter, dan jika terjadi error maka
        // akan menampilkan pesan error.
        booksViewModel.observeBooks().observe(this, Observer {
            it?.let {
                adapter.renderables = it
            }
        })
        booksViewModel.observeFailure().observe(this, Observer {
            Toast.makeText(this, R.string.error, Toast.LENGTH_LONG).show()
        })
        booksViewModel.getBooks()
    }

    // mengatur tampilan buku dengan jumlah buku yang tampil 3 perbaris.
    private fun setupRecycler() {
        recyclerView.layoutManager = GridLayoutManager(this, 3)
        recyclerView.adapter = adapter
    }
}
