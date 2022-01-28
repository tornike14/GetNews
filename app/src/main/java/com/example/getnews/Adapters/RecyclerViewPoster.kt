package com.example.recyclervieww

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.getnews.R

class RecyclerViewPoster(private val posterList: List<Person>) : RecyclerView.Adapter<RecyclerViewPoster.PosterviewHolder> (){

    class PosterviewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var imageView: ImageView
        private lateinit var texView1: TextView
        private lateinit var textView2: TextView

        init {
            imageView = itemView.findViewById(R.id.imageView)
            texView1 = itemView.findViewById(R.id.textView)
            textView2 = itemView.findViewById(R.id.textView2)
        }

        fun setData(person: Person) {
            texView1.text = person.title

            textView2.text = person.description

            Glide.with(itemView)
                .load(person.imageUrl)
                .into(imageView)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PosterviewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.poster_item , parent, false)
        return PosterviewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PosterviewHolder, position: Int) {
        holder.setData(posterList[position])
    }

    override fun getItemCount(): Int {
        return posterList.size
    }
}