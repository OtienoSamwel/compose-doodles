package com.otienosamwel.maps_compose.ui.presentation

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*


@Composable
fun Home() {
    val workList = listOf(LatLng(-1.2244064, 36.8788276), LatLng(-1.4244064, 35.8788276))
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(workList[0], 11f)
    }
    val markerDragState = rememberMarkerDragState()
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        GoogleMap(Modifier.matchParentSize(), cameraPositionState = cameraPositionState) {
            workList.forEach {
                Marker(
                    position = it,
                    markerDragState = markerDragState,
                )

                Marker(
                    position =cameraPositionState.position.target,
                )

                when (markerDragState.dragState) {
                    DragState.START -> {
                        Toast.makeText(
                            context,
                            "Started dragging ${markerDragState.dragState.name}",
                            Toast.LENGTH_SHORT
                        ).show()
                        Polyline(points = workList, color = Color.Cyan, geodesic = true, width = 2f)
                    }
                    DragState.DRAG -> {
                        Toast.makeText(
                            context,
                            "Dragging ${markerDragState.dragState.name}",
                            Toast.LENGTH_SHORT
                        ).show()
                        Polyline(points = workList, color = Color.Cyan, geodesic = true, width = 2f)
                    }
                    DragState.END -> {
                        Toast.makeText(
                            context,
                            "Stopped Dragging ${markerDragState.dragState.name}",
                            Toast.LENGTH_SHORT
                        ).show()
                        Polyline(points = workList, color = Color.Cyan, geodesic = true, width = 2f)
                    }
                }
            }
        }
    }


}