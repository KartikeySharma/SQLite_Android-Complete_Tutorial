package com.jovanovic.stefan.sqlitetutorial

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class AddActivity : AppCompatActivity() {
    var title_input: EditText? = null
    var author_input: EditText? = null
    var pages_input: EditText? = null
    var add_button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        title_input = findViewById(R.id.title_input)
        author_input = findViewById(R.id.author_input)
        pages_input = findViewById(R.id.pages_input)
        add_button = findViewById(R.id.add_button)
        add_button?.setOnClickListener(View.OnClickListener {
            val myDB = MyDatabaseHelper(this@AddActivity)
            myDB.addBook(title_input?.getText().toString().trim { it <= ' ' },
                author_input?.getText().toString().trim { it <= ' ' },
                Integer.valueOf(pages_input?.getText().toString().trim { it <= ' ' })
            )
        })
    }
}