package mam.reader.multimodule.api

  import mam.reader.multimodule.model.Book
  import mam.reader.multimodule.model.BookData
  import mam.reader.multimodule.model.Books
  import retrofit.Callback
  import retrofit.http.*

interface ApiService {

    @Headers("Content-Type: application/json")
    @GET(Api.BOOKS)
    fun getBooks() : Books

    @Headers("Content-Type: application/json")
    @GET("${Api.BOOKS}/{book_id}")
    fun getBook() : Book

    @Headers("Content-Type: application/json")
    @POST(Api.BOOKS)
    fun createBook(@Body data : HashMap<String,BookData>) : Book
}