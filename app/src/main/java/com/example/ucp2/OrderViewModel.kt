package com.example.ucp2

import androidx.lifecycle.ViewModel
import com.example.ucp2.data.OrderUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OrderViewModel : ViewModel() {
    private val _stateUI = MutableStateFlow(OrderUIState())
    val stateUI: StateFlow<OrderUIState> = _stateUI.asStateFlow()

    fun setSkripsi(listSkripsi: MutableList<String>){
        _stateUI.update {stateSaatIni ->
            stateSaatIni.copy(
                nama = listSkripsi[0],
                nim = listSkripsi[1],
                konsentrasi = listSkripsi[2],
                skripsi = listSkripsi[3]
            )
        }
    }

    fun setDosen1(dosenPembimbing1: String) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(dp1 = dosenPembimbing1)
        }
    }

    fun setDosen2(dosenPembimbing2: String) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(dp2 = dosenPembimbing2)
        }
    }
}