package com.example.bookapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton

class bookadapter(private val bookslist : ArrayList<bookdetailsclass>,context: Context) :
    RecyclerView.Adapter<bookadapter.bookViewHolder>() {

    private lateinit var btnlistener :OnbtnclickListener;

    interface OnbtnclickListener{
        fun onbtnclicklistener(position: Int);
    }

    fun btnclicklistener(listener : OnbtnclickListener){
        btnlistener = listener
    }

    //it holds the view so that the views are not created every time, so the memory can be saved
    class bookViewHolder (itemView: View,listener: OnbtnclickListener): RecyclerView.ViewHolder(itemView)
    {
        var bookimage = itemView.findViewById<ImageView>(R.id.bookpicindet);
        var bookname = itemView.findViewById<TextView>(R.id.booknameindet);
        var authorname = itemView.findViewById<TextView>(R.id.authornameindet);
        var postername = itemView.findViewById<TextView>(R.id.posternameindet);
        var button = itemView.findViewById<Button>(R.id.borrobtnindet);
        init{
            itemView.findViewById<Button>(R.id.borrobtnindet).setOnClickListener{
                listener.onbtnclicklistener(adapterPosition);
            }
        }
    }

    //to create a new view instance if the layout manager fails to find a suitable view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bookViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layouthome,parent,false)
        return bookViewHolder(view,btnlistener);
    }


    // how many list items are present in your arraylist
    override fun getItemCount(): Int {
        return bookslist.size
    }

    //populate items with data
    override fun onBindViewHolder(holder: bookViewHolder, position: Int) {
        var currentview = bookslist[position];
        holder.bookimage.setImageResource(currentview.bookIMage);
        holder.bookname.text = currentview.booknameindet;
        holder.authorname.text = currentview.authornameindet;
        holder.postername.text = currentview.posternameindet;
        holder.button = (currentview.button)
    }
}


