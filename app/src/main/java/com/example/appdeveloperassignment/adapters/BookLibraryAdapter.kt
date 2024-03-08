package com.example.appdeveloperassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.appdeveloperassignment.R
import com.example.appdeveloperassignment.data.BookListResponse
import com.example.appdeveloperassignment.databinding.RvBookLibraryItemBinding
import com.example.appdeveloperassignment.ui.utils.SharedPrefManager

class BookLibraryAdapter(private var list: MutableList<BookListResponse.BookListResponseItem>) :
    RecyclerView.Adapter<BookLibraryAdapter.BookLibraryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookLibraryViewHolder {
        val binding = RvBookLibraryItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return BookLibraryViewHolder(binding)
    }

    /*fun submitNewImageList(imageList: List<BookListResponse.BookListResponseItem>) {
        this.list = imageList
        notifyDataSetChanged()
    }*/

    override fun getItemCount(): Int {
        return list.size
    }


    override fun onBindViewHolder(holder: BookLibraryViewHolder, position: Int) {

        holder.bind(position)

    }


    inner class BookLibraryViewHolder(private val binding: RvBookLibraryItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            binding.tvBookName.text = list[position].bOOKNAME
            binding.tvIdNumber.text = list[position].bOOKID.toString()
            binding.tvAvailableNumber.text = list[position].bOOKQTY.toString()


            if (list[position].bOOKQTY == 1) {
                binding.btnBorrow.text = "Limited Quantity"
            }

            binding.btnBorrow.setOnClickListener {
                /*Navigation.findNavController(binding.root)
                    .navigate(R.id.actionBookLibraryToMyBooksFragment)*/

                if (list[position].bOOKQTY == 1) {
                    Toast.makeText(
                        binding.root.context,
                        "Limited Quantity",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }

                var count = SharedPrefManager.getBooksLimit(binding.root.context)
                if (count == 2) {
                    Toast.makeText(
                        binding.root.context,
                        "Borrowed list full",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    if (list[position].bOOKQTY > 1 && !list[position].bORROWED) {
                        count++
                        SharedPrefManager.saveBooksLimit(binding.root.context, count)
                        var qty = list[position].bOOKQTY - 1
                        list[position].bOOKQTY = qty
                        list[position].bORROWED = true
                        Toast.makeText(
                            binding.root.context,
                            "Successfully added borrowed list",
                            Toast.LENGTH_SHORT
                        ).show()

                    } else {
                        Toast.makeText(
                            binding.root.context,
                            "already borrowed",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                    notifyDataSetChanged()
                }


            }
        }

    }

}