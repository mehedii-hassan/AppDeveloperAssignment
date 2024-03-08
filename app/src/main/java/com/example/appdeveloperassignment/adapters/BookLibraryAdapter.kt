package com.example.appdeveloperassignment.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appdeveloperassignment.data.BookListResponse
import com.example.appdeveloperassignment.databinding.RvBookLibraryItemBinding

class BookLibraryAdapter(private var list: List<BookListResponse.BookListResponseItem>) :
    RecyclerView.Adapter<BookLibraryAdapter.BookLibraryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookLibraryViewHolder {
        val binding = RvBookLibraryItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return BookLibraryViewHolder(binding)
    }

    fun submitNewImageList(imageList: List<BookListResponse.BookListResponseItem>) {
        this.list = imageList
        notifyDataSetChanged()
    }

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
        }

    }

}