package com.example.myfirstapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapplication.R
import com.example.myfirstapplication.model.MovieCs

class MovRecyclerView(val context: Context, private val movies: MutableList<MovieCs>, private val onMovieClick: (position: Int) -> Unit) :
    RecyclerView.Adapter<MovRecyclerView.ViewHolder>() {

    class ViewHolder(view: View, private val onMovieClick: (position: Int) -> Unit) : RecyclerView.ViewHolder(view), View.OnClickListener{
        val id: TextView = view.findViewById(R.id.idText)
        val title: TextView = view.findViewById(R.id.titleText)
        val director: TextView = view.findViewById(R.id.directorText)

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = absoluteAdapterPosition
            onMovieClick(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_movie_row, parent, false)
        return ViewHolder(view) { position ->
            onMovieClick(
                position
            )
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentMovie = movies[position]

        holder.id.text = "id: ${currentMovie.id.toString()}"
        holder.title.text = "title: ${currentMovie.title}"
        holder.director.text = "director: ${currentMovie.director}"
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}