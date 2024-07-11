package com.example.listviewtest

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val listOfNames = mutableListOf<String>("Gagandeep","Prince","Nihal","Suraj","Premdeep")
        val namesAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listOfNames)

        val listView : ListView = findViewById(R.id.list_view)
        val edt : EditText = findViewById(R.id.edt)
        val btn : Button = findViewById(R.id.btn)

        btn.setOnClickListener {
            val name = edt.text.toString()
            listOfNames.add(name)
            namesAdapter.notifyDataSetChanged()
        }



        listView.adapter = namesAdapter

        listView.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
//                val nameClicked = listOfNames[position]
//                Toast.makeText( this@MainActivity, nameClicked, Toast.LENGTH_SHORT).show()

                listOfNames.removeAt(position)
                namesAdapter.notifyDataSetChanged()
            }
        })

    }
}