package mam.reader.multimodule.repository


import kotlinx.coroutines.*
import mam.reader.multimodule.api.Api
import mam.reader.multimodule.model.Attributes
import mam.reader.multimodule.model.Book
import mam.reader.multimodule.model.BookData
import mam.reader.multimodule.model.Books
import retrofit.RequestInterceptor
import java.lang.Exception


class BookRepository(var api: Api) {

    suspend fun getBooks(): Books {
        val request = GlobalScope.async {
            api.getBooks(null)
        }
        return request.await()
    }

    suspend fun getBook(bookId: String): Book {
        val request = GlobalScope.async {
            api.getBook(RequestInterceptor {
                it.addPathParam("book_id", bookId)
            })
        }
        return request.await()
    }

    suspend fun createBook(
        title: String,
        readerId: String,
        authorId: String,
        publisherId: Int
    ): Book? {
        var attrs = Attributes(authorId, publisherId, readerId, title)
        var data = HashMap<String, BookData>()
        var bookData = BookData(attrs, null, null, null, "Book")

        data.put("data", bookData)
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