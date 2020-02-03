package mam.reader.multimodule.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.google.android.play.core.splitinstall.*

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

        initView()

        btnBook.setOnClickListener {

            launchBook()
        }

        btnUninstallBook.setOnClickListener {
            splitInstallManager.deferredUninstall(mutableListOf("books")).addOnSuccessListener {
                initView()
            }.addOnFailureListener {
                toast("Gagal Menguninstal Fitur Books")
            }
        }

        btnPeople.setOnClickListener {
            launchPeople()
        }

        btnUninstallPeople.setOnClickListener {
            splitInstallManager.deferredUninstall(mutableListOf("people")).addOnSuccessListener {
                initView()
            }.addOnFailureListener {
                toast("Gagal Menguninstal Fitur People")
            }
        }


    }

    private fun initView() {
        if (splitInstallManager.installedModules.contains("books")) {
            btnBook.text = "Lihat"
            btnUninstallBook.visibility = View.VISIBLE

        } else {
            btnBook.text = "Install"
            btnUninstallBook.visibility = View.GONE
        }

        if (splitInstallManager.installedModules.contains("people")) {
            btnPeople.text = "Lihat"
            btnUninstallPeople.visibility = View.VISIBLE
        } else {
            btnPeople.text = "Install"
            btnUninstallPeople.visibility = View.GONE
        }

    }

    private fun launchBook() {

        if (splitInstallManager.installedModules.contains("books")) {
            var i = Intent()
            i.setClassName(BuildConfig.APPLICATION_ID, "com.example.books.view.BookActivity");
            startActivity(i)
        } else {
            val request = SplitInstallRequest.newBuilder().addModule("books").build()
            splitInstallManager.startInstall(request).addOnSuccessListener {
                initView()
            }.addOnFailureListener {
                toast("Gagal Menginstal Fitur Books")
            }
        }
    }


    private fun launchPeople() {

        if (splitInstallManager.installedModules.contains("people")) {
            startActivity(
                Intent(
                    "com.example.people.PeopleActivity"
                )
            )
        } else {
            val request = SplitInstallRequest.newBuilder().addModule("people").build()
            splitInstallManager.startInstall(request).addOnSuccessListener {
                initView()
            }.addOnFailureListener {
                toast("Gagal Menginstal Fitur People")
            }
        }
    }

    fun toast(toast: String) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show()
    }


}
