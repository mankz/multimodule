package mam.reader.multimodule.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import mam.reader.multimodule.MyApplication
import mam.reader.multimodule.R
import mam.reader.multimodule.api.Api
import mam.reader.multimodule.model.Book
import mam.reader.multimodule.viewmodel.MainViewModel
import mam.reader.multimodule.viewmodel.MyViewModelFactory

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBook.setOnClickListener {
            val i = Intent(this, BookActivity::class.java)
            startActivity(i)
        }

        btnUser.setOnClickListener {

        }

    }

}
