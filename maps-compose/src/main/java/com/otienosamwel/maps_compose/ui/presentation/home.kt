package com.otienosamwel.maps_compose.ui.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerDragState


@Composable
fun Home() {
    val workList = listOf(LatLng(-1.2244064, 36.8788276), LatLng(-1.4244064, 35.8788276))
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(workList[0], 11f)
    }
    val markerDragState = rememberMarkerDragState()
    val context = LocalContext.current

        GoogleMap(
            Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            Marker(position = workList[1])
        }
    }
