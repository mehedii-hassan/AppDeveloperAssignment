package com.example.appdeveloperassignment.data

import com.google.gson.annotations.SerializedName

data class BookListResponse(

    @field:SerializedName("BookListResponse")
    val bookListResponse: List<BookListResponseItem>
) {
    data class BookListResponseItem(

        @field:SerializedName("BOOK_QTY")
        var bOOKQTY: Int,

        @field:SerializedName("BOOK_NAME")
        var bOOKNAME: String,

        @field:SerializedName("BOOKID")
        var bOOKID: Int,

        @field:SerializedName("BORROWED")
        var bORROWED: Boolean
    )
}