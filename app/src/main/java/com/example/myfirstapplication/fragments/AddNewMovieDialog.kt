package com.example.myfirstapplication.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatDialogFragment
import com.example.myfirstapplication.R
import kotlin.random.Random

class AddNewMovieDialog: AppCompatDialogFragment() {

    private lateinit var listener: AddMovieDialogListener;

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)

        val layoutInflater = activity?.layoutInflater

        val view = layoutInflater?.inflate(R.layout.fragment_add_new_movie_dialog, null)

        val title: EditText? = view?.findViewById(R.id.newMovie)
        val actors: EditText? = view?.findViewById(R.id.newActors)
        val director: EditText? = view?.findViewById(R.id.newDirector)
        val description: EditText? = view?.findViewById(R.id.newDescription)

        val index = Random.nextInt(10,10000)

        builder.setView(view)
            .setTitle("Add Movie")
            .setPositiveButton("Add Movie") { _, _ ->
                val titleValue: String = title?.text.toString()
                val actorsValue: String = actors?.text.toString()
                val directorValue: String = director?.text.toString()
                val descriptionValue: String = director?.text.toString()

                listener.addMovie(titleValue, actorsValue, directorValue, index, descriptionValue)
            }
            .setNegativeButton("Exit") { _, _ ->

            }

        return builder.create()
    }

    fun setAddMovieDialogListener(listener: AddMovieDialogListener) {
        this.listener = listener
    }

    interface AddMovieDialogListener {
        fun addMovie(title: String, actors: String, director: String, id: Int, description: String)
    }
}