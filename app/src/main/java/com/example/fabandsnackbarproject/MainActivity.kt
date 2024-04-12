package com.example.fabandsnackbarproject

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    val listItems = ArrayList<String>()
    var adapter: ArrayAdapter<String>? = null
    var count = 0
    lateinit var listView: ListView
    lateinit var fab: FloatingActionButton
    lateinit var undoOnClickListener: View.OnClickListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.idListView)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = adapter

        fab = findViewById(R.id.idFAB)

        fab.setOnClickListener {
            count += 1
            addListItem(count)
            Snackbar.make(it, "Added an Item", Snackbar.LENGTH_LONG)
                .setAction("UNDO", undoOnClickListener).show()

            if (count == 10){
                // open congratulations activity - will return to empty list
                val intent = Intent(this, Activity2::class.java)
                startActivity(intent)
            }
        }

        undoOnClickListener = View.OnClickListener {
            listItems.removeAt(listItems.size - 1)
            adapter?.notifyDataSetChanged()
            Snackbar.make(it, "Item removed", Snackbar.LENGTH_LONG)
                .setAction("action", null).show()
        }
    }

    private fun addListItem(count: Int) {
        listItems.add("Item $count")
        adapter?.notifyDataSetChanged()
    }
}