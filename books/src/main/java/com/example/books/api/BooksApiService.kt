package com.example.books.api

  import com.example.books.model.BookData
  import retrofit.http.*

interface BooksApiService {

    @Headers("Content-Type: application/json")
    @GET(Api.BOOKS)
    fun getBooks(@Query("page[limit]") limit : Int, @Query("page[offset]") offset : Int) : com.example.books.model.Books

    @Headers("Content-Type: application/json")
    @GET("${Api.BOOKS}/{book_id}")
    fun getBook() : com.example.books.model.Book

    @Headers("Content-Type: application/json")
    @POST(Api.BOOKS)
    fun createBook(@Body data : HashMap<String, BookData>) : com.example.books.model.Book


    @Headers("Content-Type: application/json")
    @DELETE("${Api.BOOKS}/{book_id}")
    fun deleteBook() : String
}