package mam.reader.multimodule.api

import android.content.Context
import com.aksaramaya.core.api.BaseApi
import mam.reader.multimodule.model.Book
import mam.reader.multimodule.model.BookData
import mam.reader.multimodule.model.Books
import retrofit.RequestInterceptor
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class Api (context : Context): BaseApi(context){


    companion object {
        const val BASE_URL = "https://thomaxxl.pythonanywhere.com/api/"
        const val BOOKS =  "/Books"
    }

    private fun getApiService(params: RequestInterceptor?): ApiService {
        return mRestHelper.buildRestadapter(
            BASE_URL
            , 3000L
            , 3000L
            , params
            , ApiService::class.java
        )
    }

    suspend fun getBook(params: RequestInterceptor?) = suspendCoroutine<Book> {
        it.resume(getApiService(params).getBook())
    }

    suspend fun getBooks(params: RequestInterceptor?) = suspendCoroutine<Books> {
        it.resume(getApiService(params).getBooks(10, 0))
    }

    suspend fun createBook(params: RequestInterceptor?, data : HashMap<String, BookData>) = suspendCoroutine<Book> {
        it.resume(getApiService(params).createBook(data))
    }

    suspend fun deleteBook(params: RequestInterceptor?) = suspendCoroutine<String> {
        it.resume(getApiService(params).deleteBook())
    }


}