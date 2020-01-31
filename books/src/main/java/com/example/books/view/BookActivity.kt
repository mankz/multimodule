package com.example.books.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.books.R
import com.example.books.adapter.BookAdapter
import com.example.books.viewmodel.BookActivityViewModel
import kotlinx.android.synthetic.main.book_activity.*
import mam.reader.multimodule.MyApplication
import com.example.books.api.Api
import com.example.books.model.BookData
import com.example.books.viewmodel.MyViewModelFactory

class BookActivity : AppCompatActivity(), BookAdapter.BookAdapterInterface {


    lateinit var bookActivityVM: BookActivityViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.book_activity)

        bookActivityVM = ViewModelProvider(
            this, MyViewModelFactory(Api(MyApplication.getContext()))
        ).get(BookActivityViewModel::class.java)

        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_books.layoutManager = layoutManager

        bookActivityVM.getBooks().observe(this, Observer {
            val adapter = BookAdapter(this, bookActivityVM.getBooks().value!!.data!!)
            rv_books.adapter = adapter
        })

        bookActivityVM.loadBooks()

        btnCreateBook.setOnClickListener {
            val i = Intent(this@BookActivity, ManageBookActivity::class.java)
            startActivityForResult(i, 123)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 123 && resultCode == RESULT_OK) {
            val title = data!!.getStringExtra("title")
            val readerId = data!!.getStringExtra("reader_id")
            val authorId = data!!.getStringExtra("author_id")
            val publisherId = data!!.getIntExtra("publisher_id", 0)
            bookActivityVM.createBook(title, readerId, authorId, publisherId)
        }
    }

    fun log(log: String) {
        Log.d(this.javaClass.canonicalName, log)
    }

    fun toast(toast: String) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show()
    }

    override fun onBookClicked(bookData: BookData) {

        val items = arrayOf("Edit", "Delete")
        val builder = AlertDialog.Builder(this)
        builder.setTitle(bookData.attributes!!.title)
        builder.setItems(items) { dialog, which ->
            when (which) {
                0 -> {
                    toast("Coming Soon")
                }

                1 -> {
                    bookActivityVM.deleteBook(bookData.id!!)
                }
            }
        }
        builder.create().show()
    }

}