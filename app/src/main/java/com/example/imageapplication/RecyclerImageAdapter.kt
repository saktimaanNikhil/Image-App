package com.example.imageapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RecyclerImageAdapter (private val context: Context, private var modelClassArrayList: ArrayList<ApiModel>) :
    RecyclerView.Adapter<RecyclerImageAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.image_show, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerImageAdapter.ViewHolder, position: Int) {
        val model = modelClassArrayList[position]
        Glide.with(context).load(model.url).error(R.drawable.image).into(holder.imgNews)
        holder.title.text = model.title
    }

    override fun getItemCount(): Int {
        return modelClassArrayList.size
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgNews: ImageView = itemView.findViewById(R.id.imgNews)
        val title: TextView = itemView.findViewById(R.id.Title)

    }
}