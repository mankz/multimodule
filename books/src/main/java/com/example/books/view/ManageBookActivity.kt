package com.example.books.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.books.R
import kotlinx.android.synthetic.main.manage_book.*

class ManageBookActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.manage_book)

        btnSend.setOnClickListener {
            var data = Intent()
            data.putExtra("title", etTitle.text.toString())
            data.putExtra("reader_id", etReaderId.text.toString())
            data.putExtra("author_id", etAuthorId.text.toString())
            data.putExtra("publisher_id", etPublisherId.text.toString().toInt())
            setResult(RESULT_OK, data)
            finish()
        }
    }
}