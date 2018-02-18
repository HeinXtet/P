package com.heinhtet.deevd.simplepref

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import com.heinhtet.deevd.p.P
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity::class"
    val NAME = "name"
    val AGE = "age"

    val BIO_OBJECT = "bio_object"
    val BIO_OBJECT2 = "bio_object2"

    val LIST_OBJECT = "list_object"
    val LIST_OBJECT2 = "list_object2"
    val BREAK_LINE = "\n"
    data class Bio(var name: String, var age: Int, var bio: String? = null)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        saveDataType()
        saveObject()
        saveArrayList()
        action_btn.setOnClickListener({
            getDataType()
            getObject()
            getArrayList()
        })
    }

    private fun getDataType() {
        var name = P.getInstance().get(NAME)
        var age = P.getInstance().get(AGE)
        result_tv.append("Data Type Result $BREAK_LINE Name : $name Age $age $BREAK_LINE $BREAK_LINE")
    }

    private fun getObject() {
        var bio = P.getInstance().get(BIO_OBJECT, Bio::class.java)
        var bio2 = P.getInstance().get(BIO_OBJECT2, Bio::class.java)
        result_tv.append("Object Result $BREAK_LINE Bio 1 : ${bio.toString()} Bio 2 : ${bio2.toString()} $BREAK_LINE $BREAK_LINE")
    }

    private fun getArrayList() {
        var list = P.getInstance().get(LIST_OBJECT, ArrayList<String>())
        var bioList = P.getInstance().get(LIST_OBJECT2, ArrayList<Bio>())
        result_tv.append("ArrayList Result $BREAK_LINE list  : ${list.toString()} Bio List  : ${bioList.toString()} $BREAK_LINE$BREAK_LINE")

    }

    private fun saveDataType() {
        P.getInstance().put(NAME, "Hein Htet")
        P.getInstance().put(AGE, 23)
    }

    private fun saveObject() {
        var bio = Bio("Hein Htet", 23, "Love Coding")
        var bio2 = Bio("Android", 27, "Android is developed by Google.Inc")
        P.getInstance().put(BIO_OBJECT, bio)
        P.getInstance().put(BIO_OBJECT2, bio2)
    }

    private fun saveArrayList() {
        var list = ArrayList<String>()
        var bioList = ArrayList<Bio>()
        for (i in 1..10) {
            list.add("Count + $i")
        }
        bioList.add(Bio("ReactiveX", 23, "Netflix"))
        bioList.add(Bio("Swift", 23, "Apple"))
        P.getInstance().put(LIST_OBJECT, list)
        P.getInstance().put(LIST_OBJECT2, bioList)
    }
}
