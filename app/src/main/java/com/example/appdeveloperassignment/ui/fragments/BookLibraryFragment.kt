package com.example.appdeveloperassignment.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.appdeveloperassignment.R
import com.example.appdeveloperassignment.adapters.BookLibraryAdapter
import com.example.appdeveloperassignment.databinding.FragmentBookLibraryBinding
import com.example.appdeveloperassignment.ui.utils.Constants.parseJsonToModel
import com.example.appdeveloperassignment.ui.utils.Constants.readJsonFromAssets
import com.example.appdeveloperassignment.ui.utils.SharedPrefManager


class BookLibraryFragment : Fragment() {


    private lateinit var binding: FragmentBookLibraryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBookLibraryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val jsonString = readJsonFromAssets(requireContext(), "book_list.json")
        var bookList = parseJsonToModel(jsonString).toMutableList()


        val key = arguments?.getString("key")
        if (key == "1") {

            val adapter = SharedPrefManager.getBookList(requireContext())
                ?.let { BookLibraryAdapter(it) }
            binding.rvBookLibrary.layoutManager =
                GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
            binding.rvBookLibrary.adapter = adapter
        } else {

            val adapter = BookLibraryAdapter(bookList)
            binding.rvBookLibrary.layoutManager =
                GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)
            binding.rvBookLibrary.adapter = adapter
        }
        //Toast.makeText(context, "size ${bookList.size}", Toast.LENGTH_LONG).show()


    }
}