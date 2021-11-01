package com.example.recipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

import kotlin.collections.ArrayList


class MainActivity : AppCompatActivity() {

     var newRecipe=ArrayList<String>()
    val TAG="data"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv=findViewById<RecyclerView>(R.id.rvMain)
        val db = Firebase.firestore



        rv.adapter= recycler(newRecipe)
        rv.layoutManager= LinearLayoutManager(this)

        var displayResponse = ""
        db.collection("Recipes")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                    document.data.map {
                        (key,value)->
                        displayResponse="$key : $value \n"
                        newRecipe.add(displayResponse)
                    }
                    rv.adapter= recycler(newRecipe)
                    rv.layoutManager= LinearLayoutManager(this)
                    rv.scrollToPosition(newRecipe.size-1)


                }
            }
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents.", exception)
            }
// Add






                 /*   for (datum in response.body()!!) {
                        Log.d("responseBody","${datum.author} ${newRecipe.size}")
                        displayResponse = """${datum.pk} ${datum.author} ${datum.title} ${datum.ingredients} ${datum.instructions}"""
                        newRecipe.add(displayResponse)
                        rv.adapter?.notifyDataSetChanged()



                    }*/
                    rv.scrollToPosition(newRecipe.size-1)







    }


    fun adduser(view: android.view.View) {

        intent = Intent(applicationContext, MainActivity2::class.java)
        startActivity(intent)

    }

}


