package com.example.appdeveloperassignment.adapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.appdeveloperassignment.R
import com.example.appdeveloperassignment.data.BookListResponse
import com.example.appdeveloperassignment.databinding.RvBookLibraryItemBinding
import com.example.appdeveloperassignment.databinding.RvMyBooksItemBinding
import com.example.appdeveloperassignment.ui.utils.SharedPrefManager

class MyBooksAdapter(private var list: MutableList<BookListResponse.BookListResponseItem>) :
    RecyclerView.Adapter<MyBooksAdapter.BookLibraryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookLibraryViewHolder {
        val binding = RvMyBooksItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return BookLibraryViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(holder: BookLibraryViewHolder, position: Int) {

        holder.bind(position)

    }


    inner class BookLibraryViewHolder(private val binding: RvMyBooksItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            if (list[position].bORROWED) {
                binding.root.visibility = View.VISIBLE
                binding.tvBookName.text = list[position].bOOKNAME
                binding.tvIdNumber.text = list[position].bOOKID.toString()
            }/* else {
                binding.root.visibility = View.GONE

            }*/


            binding.btnReturnBook.setOnClickListener {

                var qty = list[position].bOOKQTY + 1
                list[position].bOOKQTY = qty
                list[position].bORROWED = false
                Toast.makeText(
                    binding.root.context,
                    "Successfully removed borrowed list",
                    Toast.LENGTH_SHORT
                ).show()

                SharedPrefManager.saveBookList(binding.root.context, list)
                val bundle = Bundle()
                bundle.putString("key", "1")

                Navigation.findNavController(binding.root)
                    .navigate(R.id.actionToLibraryFragment, bundle)
            }
        }

    }

}