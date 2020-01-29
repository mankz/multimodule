package mam.reader.multimodule.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory

import kotlinx.android.synthetic.main.activity_main.*
import mam.reader.multimodule.R

class MainActivity : AppCompatActivity() {


    // untuk dynamic features
    lateinit var splitInstallManager: SplitInstallManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        splitInstallManager = SplitInstallManagerFactory.create(this)

        btnBook.setOnClickListener {
            launchBook()
        }

        btnUser.setOnClickListener {
            launchPeople()
        }

    }

    fun launchBook() {

        if (splitInstallManager.installedModules.contains("books")) {
            startActivity(Intent(
                "com.example.books.view.BookActivity"))
        } else {
            toast("Books belum terinstall")
        }
    }


    fun launchPeople() {

        if (splitInstallManager.installedModules.contains("people")) {
            startActivity(Intent(
                "com.example.people.PeopleActivity"))
        } else {
            toast("People belum terinstall")
        }
    }

    fun toast(toast : String){
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show()
    }
}
