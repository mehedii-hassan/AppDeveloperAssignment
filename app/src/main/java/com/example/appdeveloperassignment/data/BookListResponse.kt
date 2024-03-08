package com.example.appdeveloperassignment.data

import com.google.gson.annotations.SerializedName

data class BookListResponse(

    @field:SerializedName("BookListResponse")
    val bookListResponse: List<BookListResponseItem>
) {
    data class BookListResponseItem(

        @field:SerializedName("BOOK_QTY")
        val bOOKQTY: Int,

        @field:SerializedName("BOOK_NAME")
        val bOOKNAME: String,

        @field:SerializedName("BOOKID")
        val bOOKID: Int,

        @field:SerializedName("BORROWED")
        val bORROWED: Boolean
    )
}