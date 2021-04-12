package com.example.nikolaiturev.finallyproject.presentation.gallery_photo_details.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.nikolaiturev.finallyproject.R

class PhotoDetailsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val imagePhotoDetails: ImageView = view.findViewById(R.id.image_view_details_image)

    fun get() : Int = adapterPosition
}

