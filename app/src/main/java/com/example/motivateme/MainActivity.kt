package com.example.motivateme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView




class MainActivity : AppCompatActivity() {
    //Declare references to views before layout inflation
    private lateinit var name : EditText
    private  lateinit var message : TextView

    // technically you can define below val in update message method but finding views by id can be resource intensive everytime the method is called
    // so late-init is preferred
    //val name: EditText = findViewById(R.id.editTextTextPersonName)
    //val message:TextView=findViewById((R.id.main_activity_tv_message)) ( another way to define )
    //val message = findViewById<TextView>(R.id.main_activity_tv_message)

    //Override lifecycle onCreate method. This should initialize all the important items for the code.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Inflate the given layout to turn xml views into kotlin objects.
        setContentView(R.layout.activity_main)

        //Get a reference to the button view from our layout and set a click listener
        //val is read only i.e immutable
        val updateButton : Button = findViewById(R.id.activity_main_bt_update)

        updateButton.setOnClickListener { updateMessage() }

        //Set the value to our declared views
        name = findViewById(R.id.editTextTextPersonName)
        message = findViewById(R.id.main_activity_tv_message)


    }

    //get a name from edit text and display a personalised message
    private  fun updateMessage(){


        // get username from edittext
        val userName = name.text

        //Pick a motivational message
        val motivationalMessages = listOf("Keep working hard!","Never give up!","It's all worth in the end.","Success doesn't come easily!","Remember why you started")

        val index=(0..4).random()
        val currentMessage = motivationalMessages[index]

        //update the textview to display our message
        if (userName.toString()==""){
            message.text="Make sure you enter your name!"
        } else {
            message.text="Hello $userName, $currentMessage"
        }


        //CLear edittext and use setText() because editText's require an editable
        name.setText("")
        hideKeyboard()

    }

    //Hide keyboard using an InputMethodManager
    private fun hideKeyboard(){
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(name.windowToken, 0)
    }

}