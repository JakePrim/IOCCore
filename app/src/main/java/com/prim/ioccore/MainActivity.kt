package com.prim.ioccore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.prim.lib_ioc.ContentView

@ContentView(value = R.layout.activity_main)
class MainActivity : BaseActivity() {


    lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}
