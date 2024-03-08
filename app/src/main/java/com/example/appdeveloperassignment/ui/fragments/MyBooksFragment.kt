package com.example.appdeveloperassignment.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.addCallback
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appdeveloperassignment.R
import com.example.appdeveloperassignment.adapters.BookLibraryAdapter
import com.example.appdeveloperassignment.adapters.MyBooksAdapter
import com.example.appdeveloperassignment.databinding.FragmentMyBooksBinding
import com.example.appdeveloperassignment.ui.utils.Constants
import com.example.appdeveloperassignment.ui.utils.SharedPrefManager

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

        requireActivity().onBackPressedDispatcher.addCallback {
            val bundle = Bundle()
            bundle.putString("key", "1")

            Navigation.findNavController(binding.root)
                .navigate(R.id.actionToLibraryFragment, bundle)
        }
        val jsonString = Constants.readJsonFromAssets(requireContext(), "book_list.json")
        val bookList = SharedPrefManager.getBookList(requireContext())

        if (bookList?.isEmpty() != true) {
            val adapter = bookList?.let { MyBooksAdapter(it) }
            binding.rvMyBooks.layoutManager =
                LinearLayoutManager(context)
            binding.rvMyBooks.adapter = adapter
        }


    }

}