package com.example.bookapplication

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class bookdetailsactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookdetailsactivity)

        val bookbgimg = intent.getIntExtra("bookbgimg",R.drawable.book1);
        val bookimg = intent.getIntExtra("bookimg",R.drawable.book1);
        val bookname = intent.getStringExtra("bookname");
        val bookauthorname = intent.getStringExtra("bookauthorname");
        val bookpostername = intent.getStringExtra("bookpostername");
        val bookdescription = intent.getStringExtra("bookdescription");

        val bkbgimg = findViewById<ImageView>(R.id.bookbgimg);
        val bkimg = findViewById<ImageView>(R.id.bookimg);
        val bkname = findViewById<TextView>(R.id.bookname);
        val bkathrname = findViewById<TextView>(R.id.bookauthorname);
        val bkpstrname = findViewById<TextView>(R.id.postername);
        val bkdesc = findViewById<TextView>(R.id.bookdec);

        bkbgimg.setImageResource(bookbgimg);
        bkimg.setImageResource(bookimg);
        bkname.text = bookname;
        bkathrname.text = bookauthorname;
        bkpstrname.text = bookpostername;
        bkdesc.text = bookdescription;

        val btn = findViewById<Button>(R.id.borrowbookbtn);
        btn.setOnClickListener {
            val options = arrayOf("1","2","3","4")
            val builder = AlertDialog.Builder(this);
            builder.setTitle("Choose the number days you want to borrow the book");
            builder.setSingleChoiceItems(options,0,DialogInterface.OnClickListener { dialogInterface, i ->
                Toast.makeText(this,"You have selected ${options[i]} days to borrow the book",Toast.LENGTH_SHORT).show();
            })
            builder.setPositiveButton("Choose",DialogInterface.OnClickListener { dialogInterface, i ->

            })
            builder.setNegativeButton("Cancel",DialogInterface.OnClickListener { dialogInterface, i ->

            })
            builder.show()
        }

        val backbutton = findViewById<ImageButton>(R.id.backbutton);
        backbutton.setOnClickListener{
            onBackPressed();
        }

    }


}


