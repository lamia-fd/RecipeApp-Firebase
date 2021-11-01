package com.example.recipeapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class MainActivity2 : AppCompatActivity() {
    val TAG = "DATA"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val title = findViewById<EditText>(R.id.editTextTextPersonName2)
        val author = findViewById<EditText>(R.id.editTextTextPersonName3)
        val inge = findViewById<EditText>(R.id.editTextTextPersonName4)
        val ins = findViewById<EditText>(R.id.editTextTextPersonName5)
        val savebtn = findViewById<Button>(R.id.button)
        val db = Firebase.firestore

        savebtn.setOnClickListener {
            if (title.text.toString().isNotBlank() && author.text.toString().isNotBlank() &&
                inge.text.toString().isNotBlank() && ins.text.toString().isNotBlank()
            ) {

                // Create a new user with a first and last name
                val Recipes = hashMapOf(
                    "title" to title.text.toString(),
                    "author" to author.text.toString(),
                    "ingredient" to inge.text.toString(),
                    "instruction" to ins.text.toString()
                )

// Add a new document with a generated ID
                db.collection("Recipes")
                    .add(Recipes)
                    .addOnSuccessListener { documentReference ->
                        Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                    }
                    .addOnFailureListener { e ->
                        Log.w(TAG, "Error adding document", e)
                    }
            }
        }
    }


    fun viewreceipe(view: android.view.View) {
        intent = Intent(applicationContext, MainActivity::class.java)
        startActivity(intent)
    }
}