package com.example.multipleactivities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var text: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        text = findViewById(R.id.text)


//        button.setOnClickListener {
//            startActivity(Intent(this, SecondActivity::class.java))
//        }
    }

    fun mainButton(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
        startActivityForResult(intent, 2)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            2-> {
                if (resultCode == RESULT_OK) {
                    text.text = data!!.getStringExtra("value")
                }
            }
        }
    }
}