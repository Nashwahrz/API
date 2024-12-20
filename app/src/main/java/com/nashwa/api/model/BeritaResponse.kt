package com.nashwa.api.model

import android.graphics.pdf.models.ListItem

data class BeritaResponse(
    val success : Boolean,
    val message : String,
    val data : ArrayList<ListItems>
) {
    data class ListItems(
        val id: String,
        val judul : String,
        val isi: String,
        val tgl_indonesia_berita: String,
        val gambar : String,
        val rating : Float
    )
}
