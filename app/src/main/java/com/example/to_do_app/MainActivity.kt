package com.example.to_do_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        deleteAll.setOnClickListener {
            DataObject.deleteAll()
            setRecycler()
        }
        add.setOnClickListener {
            startActivity(Intent(this,CreateCard::class.java))
        }

        setRecycler()
    }

    fun setRecycler(){
        recycle_view.adapter=Adapter(DataObject.getAllData())
        recycle_view.layoutManager= LinearLayoutManager(this)
    }
}

