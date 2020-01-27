package mam.reader.multimodule.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mam.reader.multimodule.api.Api
import mam.reader.multimodule.model.Books
import mam.reader.multimodule.repository.BookRepository

class BookActivityViewModel(api: Api) : ViewModel() {

    private val repository = BookRepository(api)

    fun log(log: String) {
        Log.d("BOOK REPOSITORY", log)
    }

    var books: MutableLiveData<Books> = MutableLiveData()

    fun getBooks(): LiveData<Books> {
        return books
    }

    fun loadBooks() {
        log("loadBooks")
        viewModelScope.launch {
            books.value = repository.getBooks()
        }
    }

    fun createBook(title: String, readerId: String, authorId: String, publisherId: Int) {
        log("createBook")
        viewModelScope.launch {
            val book = repository.createBook(title, readerId, authorId, publisherId)
            book?.let {
                // nambahin data
                books.value!!.data!!.add(0, book.data!!)
                books.postValue(books.value)

            }
        }
    }
}