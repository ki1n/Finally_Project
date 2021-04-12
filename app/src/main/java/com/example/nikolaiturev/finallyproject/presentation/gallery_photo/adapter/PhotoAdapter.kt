package com.example.nikolaiturev.finallyproject.presentation.gallery_photo.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.nikolaiturev.finallyproject.R
import com.example.nikolaiturev.finallyproject.domain.entity.Photo
import com.example.nikolaiturev.finallyproject.exstension.inflate
import com.example.nikolaiturev.finallyproject.exstension.loadImage
import com.example.nikolaiturev.finallyproject.exstension.setOnDebouncedClickListener

class PhotoAdapter : ListAdapter<Photo, RecyclerView.ViewHolder>(PhotoDiffCallback()) {

    lateinit var onDeleteClickListener: ((Photo) -> Unit)
    lateinit var onAddClickListener: ((Unit) -> Unit)
    lateinit var onClickListener: ((Unit) -> Unit)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.item_photo -> {
                PhotoAdapterViewHolder(parent.inflate(R.layout.item_photo))
            }
            R.layout.item_button_photo_add -> {
                PlaceholderViewHolder(parent.inflate(R.layout.item_button_photo_add))
            }
            else -> throw IllegalArgumentException("unknown view type $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            R.layout.item_photo -> {
                val currentPhoto = currentList[position]
                (holder as PhotoAdapterViewHolder)
                with(holder) {
                    bind(currentPhoto)
                    imagePhoto.loadImage(currentPhoto.image)
                    deletePhoto.setOnDebouncedClickListener {
                        onDeleteClickListener.invoke(currentPhoto)
                    }
                    imagePhoto.setOnDebouncedClickListener {
                        onClickListener.invoke(Unit)
                    }
                }
            }
            R.layout.item_button_photo_add -> {
                (holder as PlaceholderViewHolder)
                holder.photoAdd.setOnDebouncedClickListener {
                    onAddClickListener.invoke(Unit)
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            currentList.size -> R.layout.item_button_photo_add
            else -> R.layout.item_photo
        }
    }

    override fun getItemCount(): Int {
        return currentList.size + 1
    }
}

