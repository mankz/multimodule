package mam.reader.multimodule

import android.content.Context
import com.aksaramaya.core.MocoApp
import com.aksaramaya.core.MocoApp.Companion.getAppContext
import com.google.android.play.core.splitcompat.SplitCompatApplication

class MyApplication : MocoApp(){

    companion object {
        fun getContext() : Context {
            return getAppContext()
        }
    }
}