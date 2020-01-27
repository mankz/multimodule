package mam.reader.multimodule.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mam.reader.multimodule.R
import mam.reader.multimodule.model.BookData

class BookAdapter(var context : Context, var books : List<BookData>) : RecyclerView.Adapter<BookAdapter.Holder>(){
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val book = books[position]
        holder.tvName.text = "Title : ${book.attributes!!.title}"
        holder.tvDesc.text = "Book Id : ${book.id}"
     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.book_item, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return books.size
    }


    class Holder(view : View) : RecyclerView.ViewHolder (view){
        val tvName: TextView = view.findViewById(R.id.tv_book_title)
        val tvDesc : TextView = view.findViewById(R.id.tv_book_desc)
    }
}