package com.example.bookapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView;
    lateinit var bookslist : ArrayList<bookdetailsclass>;


    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        recyclerView = findViewById(R.id.rcv1);

        val bookimages = arrayOf(
            R.drawable.book1,
            R.drawable.book2,
            R.drawable.book3,
            R.drawable.book4,
            R.drawable.book5,
        )


        val booknames = arrayOf(
            "ELON MUSK",
            "RICH DAD POOR DAD",
            "CATCH - 22",
            "PRIDE AND PREJUDICE",
            "THE GREAT GATSBY",
            )

        val authornames = arrayOf(
            "AUTHOR 1",
            "AUTHOR 2",
            "AUTHOR 3",
            "AUTHOR 4",
            "AUTHOR 5",
            )

        val posternames = arrayOf(
            "POSTER 1",
            "POSTER 2",
            "POSTER 3",
            "POSTER 4",
            "POSTER 5",
            )

        val bookcontent = arrayOf(
            getString(R.string.book_desc_1),
            getString(R.string.book_desc_2),
            getString(R.string.book_desc_3),
            getString(R.string.book_desc_4),
            getString(R.string.book_desc_5),
            )


        var button = findViewById<Button>(R.id.borrobtnindet);

        //print(button)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        bookslist = arrayListOf<bookdetailsclass>();

        for(index in bookimages.indices){
            val bookdetails = bookdetailsclass(bookimages[index],booknames[index],authornames[index],posternames[index],findViewById<Button>(R.id.borrobtnindet),bookcontent[index]);
            bookdetails.button = findViewById<Button>(R.id.borrobtnindet);
            bookslist.add(bookdetails);
        }


        val adapter = bookadapter(bookslist,this);
        recyclerView.adapter = adapter;
        adapter.btnclicklistener(object : bookadapter.OnbtnclickListener{
            override fun onbtnclicklistener(position: Int) {
                //code for the action that we want to perform
                val intent = Intent(this@MainActivity,bookdetailsactivity ::class.java);
                intent.putExtra("bookbgimg",bookslist[position].bookIMage);
                intent.putExtra("bookimg",bookslist[position].bookIMage);
                intent.putExtra("bookname",bookslist[position].booknameindet);
                intent.putExtra("bookauthorname",bookslist[position].authornameindet);
                intent.putExtra("bookpostername",bookslist[position].posternameindet);
                intent.putExtra("bookdescription",bookslist[position].book_dec);

                startActivity(intent);
            }

        })

    }


}