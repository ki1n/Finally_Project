package com.example.nikolaiturev.finallyproject.presentation.gallery_photo_details.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.nikolaiturev.finallyproject.R
import com.example.nikolaiturev.finallyproject.domain.entity.Image
import com.example.nikolaiturev.finallyproject.exstension.inflate
import com.example.nikolaiturev.finallyproject.exstension.loadImage
import com.example.nikolaiturev.finallyproject.exstension.setOnDebouncedClickListener

class PhotoDetailsAdapter : ListAdapter<Image, PhotoDetailsViewHolder>(ImageDiffCallback()) {

    lateinit var onClickListener: ((Int) -> Unit)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoDetailsViewHolder {
        return PhotoDetailsViewHolder(parent.inflate(R.layout.item_details_image))
    }

    override fun onBindViewHolder(holder: PhotoDetailsViewHolder, position: Int) {
        val currentImage = currentList[position]
        holder.imagePhotoDetails.loadImage(currentImage.image)
        holder.imagePhotoDetails.setOnDebouncedClickListener {
            onClickListener.invoke(holder.get())
        }
    }
}
