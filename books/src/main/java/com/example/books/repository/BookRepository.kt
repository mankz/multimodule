package com.example.books.repository


import kotlinx.coroutines.*
import com.example.books.api.Api
import com.example.books.model.BookData
import mam.reader.multimodule.model.Attributes
import retrofit.RequestInterceptor
import java.lang.Exception


class BookRepository(var api: Api) {

    suspend fun getBooks(): com.example.books.model.Books {
        val request = GlobalScope.async {
            api.getBooks(null)
        }
        return request.await()
    }

    suspend fun getBook(bookId: String): com.example.books.model.Book {
        val request = GlobalScope.async {
            api.getBook(RequestInterceptor {
                it.addPathParam("book_id", bookId)
            })
        }
        return request.await()
    }

    suspend fun deleteBook(bookId : String) : String? {
        val request = GlobalScope.async {
            api.deleteBook(RequestInterceptor {
                it.addPathParam("book_id", bookId)
            })

        }
        try {
            return request.await()
        } catch(e : Exception){
            e.printStackTrace()
        }
        return null
    }

    suspend fun createBook(
        title: String,
        readerId: String,
        authorId: String,
        publisherId: Int
    ): com.example.books.model.Book? {
        var attrs = Attributes(authorId, publisherId, readerId, title)
        var data = HashMap<String, BookData>()
        var bookData = BookData(attrs, null, null, null, "Book")

        data["data"] = bookData
        val request = GlobalScope.async {
            api.createBook(null, data)
        }
        try {
            return request.await()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

}