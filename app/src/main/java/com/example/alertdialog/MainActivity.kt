package com.example.alertdialog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dialogue = AlertDialog.Builder(this)
            .setTitle("Add Contact")
            .setMessage("Do you want to add Mr.TA to your contacts")
            .setIcon(R.drawable.ic_add_contact_foreground)
            .setPositiveButton("Yes"){ _,_->
                Toast.makeText(this,"you have successfully added Mr.TA to your contact list",Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("No"){ _,_->
                Toast.makeText(this,"You didn't added Mr.TA to your contact list",Toast.LENGTH_LONG).show()
            }.create()

        val button1:Button = findViewById(R.id.button1)

        button1.setOnClickListener {
            dialogue.show()
        }

        val options = arrayOf("1st item","2nd item","3rd item")
        val singleChoice = AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setSingleChoiceItems(options,0){dialogue,i->
                Toast.makeText(this,"You clicked ${options[i]}",Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept"){ _,_->
                Toast.makeText(this,"you have accepted singleChoiceItem",Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("Decline"){ _,_->
                Toast.makeText(this,"You didn't accept singleChoiceItem",Toast.LENGTH_LONG).show()
            }.create()

        val button2:Button = findViewById(R.id.button2)

        button2.setOnClickListener {
            singleChoice.show()
        }

        val multiChoice = AlertDialog.Builder(this)
            .setTitle("Choose one of these options")
            .setMultiChoiceItems(options, booleanArrayOf(false,false,false)){ dialogue, i, isChecked->
                if (isChecked)
                    Toast.makeText(this,"You clicked ${options[i]}",Toast.LENGTH_SHORT).show()
            }
            .setPositiveButton("Accept"){ _,_->
                Toast.makeText(this,"you have accepted singleChoiceItem",Toast.LENGTH_LONG).show()
            }
            .setNegativeButton("Decline"){ _,_->
                Toast.makeText(this,"You didn't accept multiChoiceItem",Toast.LENGTH_LONG).show()
            }.create()

        val button3:Button = findViewById(R.id.button3)

        button3.setOnClickListener {
            multiChoice.show()
        }
    }
}