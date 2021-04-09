package com.example.nikolaiturev.finallyproject.presentation.map

import android.annotation.SuppressLint
import com.example.nikolaiturev.finallyproject.presentation.base.BaseViewModel
import com.google.android.gms.maps.GoogleMap

class MapViewModel() : BaseViewModel() {

    lateinit var map: GoogleMap

    @SuppressLint("MissingPermission")
    fun geo() {
        if (!::map.isInitialized) return
        map.isMyLocationEnabled = true
    }
}
