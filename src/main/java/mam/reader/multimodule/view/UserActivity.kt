package mam.reader.multimodule.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.user_activity.*
import mam.reader.multimodule.R

class UserActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_activity)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)
        rv_users.layoutManager = layoutManager
     }
}