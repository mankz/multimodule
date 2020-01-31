package mam.reader.multimodule.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory

import kotlinx.android.synthetic.main.activity_main.*
import mam.reader.multimodule.BuildConfig
import mam.reader.multimodule.R

class MainActivity : AppCompatActivity() {


    // untuk dynamic features
    lateinit var splitInstallManager: SplitInstallManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        splitInstallManager = SplitInstallManagerFactory.create(this)
        val modules  = splitInstallManager.installedModules
        modules.forEach {
            Log.d("MODULE", it)
        }
        btnBook.setOnClickListener {
            launchBook()
        }

        btnUser.setOnClickListener {
            launchPeople()
        }

    }

    private fun launchBook() {

        if (splitInstallManager.installedModules.contains("books")) {
            var i = Intent()
            i.setClassName(BuildConfig.APPLICATION_ID, "com.example.books.view.BookActivity");
            startActivity(i)
        } else {
            toast("Books belum terinstall")
        }
    }


    private fun launchPeople() {

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
