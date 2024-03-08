package com.example.appdeveloperassignment.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appdeveloperassignment.R
import com.example.appdeveloperassignment.adapters.BookLibraryAdapter
import com.example.appdeveloperassignment.adapters.MyBooksAdapter
import com.example.appdeveloperassignment.databinding.FragmentMyBooksBinding
import com.example.appdeveloperassignment.ui.utils.Constants

class MyBooksFragment : Fragment() {

    private lateinit var binding: FragmentMyBooksBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyBooksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val jsonString = Constants.readJsonFromAssets(requireContext(), "book_list.json")
        val bookList = Constants.parseJsonToModel(jsonString)
        Toast.makeText(context, "size ${bookList.size}", Toast.LENGTH_LONG).show()


        val adapter = MyBooksAdapter(bookList)
        binding.rvMyBooks.layoutManager =
            LinearLayoutManager(context)
        binding.rvMyBooks.adapter = adapter
    }

}