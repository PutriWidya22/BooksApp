package com.putri.booksapp.presentation.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.putri.booksapp.R
import com.putri.booksapp.presentation.extensions.inflate
import com.putri.booksapp.presentation.extensions.loadImage
import com.putri.booksapp.presentation.presentationmodel.BookPresentationModel
import kotlinx.android.synthetic.main.row_book.view.image
import kotlin.properties.Delegates
import kotlin.time.ExperimentalTime
import kotlin.time.TimeSource

// membuat class BooksAdapter yang digunakan sebagai adapter dengan recyclerview
class BooksAdapter : RecyclerView.Adapter<BooksAdapter.ViewHolder>() {
    var renderables: List<BookPresentationModel> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    @OptIn(ExperimentalTime::class)
    private val totalMark by lazy { TimeSource.Monotonic.markNow() }

    // fungsi onCreateViewHolder yang nantinya terhubung dengan layout row_book
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent.inflate(R.layout.row_book))

    override fun getItemCount(): Int = renderables.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(renderables[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: BookPresentationModel) {
            itemView.image.loadImage(model.image, totalMark)
        }
    }
}