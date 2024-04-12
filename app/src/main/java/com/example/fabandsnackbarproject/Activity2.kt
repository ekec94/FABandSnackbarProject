package com.example.fabandsnackbarproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar



class Activity2 : AppCompatActivity() {

    lateinit var undoOnClickListener: View.OnClickListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val returnBtn: Button = findViewById(R.id.idButton)

        returnBtn.setOnClickListener {
            Snackbar.make(it, "Are you sure?", Snackbar.LENGTH_LONG)
                .setAction("YES, GO BACK", undoOnClickListener).show()
        }

        undoOnClickListener = View.OnClickListener {
            // return to main activity and start again
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}