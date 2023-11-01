package com.example.vozdux.presenter.drone_list

import com.example.vozdux.domain.model.drone.Drone

data class DronesListState(
    val drones: List<Drone>
)

sealed class DroneListScreenState {

    object isLoading: DroneListScreenState()
    object isVisible: DroneListScreenState()

}
