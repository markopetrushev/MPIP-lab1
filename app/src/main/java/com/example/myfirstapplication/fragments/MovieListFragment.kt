package com.example.myfirstapplication.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.navigation.fragment.findNavController
import com.example.myfirstapplication.R
import com.example.myfirstapplication.adapter.MovRecyclerView
import com.example.myfirstapplication.model.MovieCs
import com.example.myfirstapplication.service.FakeApi

/**
 * A simple [Fragment] subclass.
 * Use the [MovieListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MovieListFragment : Fragment(R.layout.fragment_movie_list) {

    private lateinit var data: MutableList<MovieCs>
    private val service = FakeApi()
    private lateinit var adapter : MovRecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        data = service.getAllMovies()

        val view = inflater.inflate(R.layout.fragment_movie_list, container, false)
        val recyclerView = view.findViewById<RecyclerView>(R.id.movieListRecyclerView);
        recyclerView.setHasFixedSize(true)

        recyclerView.layoutManager = LinearLayoutManager(view.context)

        adapter = MovRecyclerView(view.context, data){ position ->
            onMovieClick(
                position
            )
        }

        recyclerView.adapter = adapter

        val dialogButton = view.findViewById<Button>(R.id.addNewMovie)
        dialogButton.setOnClickListener{
            openDialog()
        }

        return view
    }

    private fun onMovieClick(position: Int){
        val action = MovieListFragmentDirections.actionMovieListFragmentToMovieDetailsFragment(data[position])
        findNavController().navigate(action)
    }

    private fun openDialog() {
        val dialogInstance = AddNewMovieDialog()
        dialogInstance.setAddMovieDialogListener(this)
        fragmentManager?.let { dialogInstance.show(it, "Add A Movie") }
    }

    override fun addNewMovie(
        title: String,
        actors: String,
        director: String,
        id: Int,
        description: String
    ) {
        val actorsList: MutableList<String>  = actors.split(";") as MutableList<String>
        val movie = MovieCs(id.toLong(), title, description, director, actorsList)
        service.addMovie(movie)
        adapter.notifyItemChanged(0)
    }
}