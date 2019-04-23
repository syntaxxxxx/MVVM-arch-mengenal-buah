
package com.syntax.android.buah.view.utama

import android.arch.lifecycle.ViewModel
import com.syntax.android.buah.model.BuahRepository
import com.syntax.android.buah.model.room.RoomRepository

class MainViewModel(private val repository: BuahRepository = RoomRepository()) : ViewModel() {

  private val allCreaturesLiveData = repository.getAllBuah()

  fun getAllCreaturesLiveData() = allCreaturesLiveData

  fun clearAllCreatures() = repository.deleteAllBuah()
}