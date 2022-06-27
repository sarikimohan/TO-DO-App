package com.example.to_do_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import kotlinx.android.synthetic.main.activity_update_card.*

class UpdateCard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_card)
        val pos=intent.getIntExtra("id",-1)

        if(pos!=-1){
            val title= DataObject.getData(pos).title
            val priority= DataObject.getData(pos).priority
            update_title.setText(title)
            update_priority.setText(priority)

            delete.setOnClickListener {
                DataObject.deleteData(pos)
                callIntent()
            }

            update.setOnClickListener {
                DataObject.UpdateData(pos,update_title.text.toString(),update_priority.text.toString())
                callIntent()
            }
        }
    }
    fun callIntent(){
        startActivity(Intent(this,MainActivity::class.java))
    }
}