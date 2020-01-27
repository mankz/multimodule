package mam.reader.multimodule.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import mam.reader.multimodule.api.Api
import mam.reader.multimodule.model.Book
import mam.reader.multimodule.repository.BookRepository

class MainViewModel(api: Api) : ViewModel() {


    private val repository = BookRepository(api)
    private var book = MutableLiveData<Book>()

    fun getBook(): LiveData<Book> {
        return book
    }

    fun getBookDetail(bookId: String) {
        viewModelScope.launch {
           book.value =  repository.getBook(bookId)
        }
    }

}