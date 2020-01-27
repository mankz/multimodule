package mam.reader.multimodule

import android.content.Context
import com.aksaramaya.core.MocoApp

class MyApplication : MocoApp(){
    companion object {
        fun getContext() : Context {
            return getAppContext()
        }
    }
}