package com.syntax.android.buah.view.detail

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.syntax.android.buah.model.*
import com.syntax.android.buah.model.room.RoomRepository

class DetailViewModel(private val generate: BuahGenerate = BuahGenerate(),
                      private val repository: BuahRepository = RoomRepository()) : ViewModel() {

    private val buahLiveData = MutableLiveData<Buah>()
    private val saveLiveData = MutableLiveData<Boolean>()

    fun getBuahLiveData(): LiveData<Buah> = buahLiveData
    fun getSaveLiveData(): LiveData<Boolean> = saveLiveData

    var name = ""
    var jumlah = 0
    var drawable = 0

    lateinit var creature: Buah

    fun updateBuah() {
        val attributes = BuahAttribute(jumlah)
        creature = generate.generateCreature(attributes, name, drawable)
        buahLiveData.postValue(creature)
    }

    fun attributeSelected(attributeType: AttributeType, position: Int) {
        when (attributeType) {
            AttributeType.JUMLAH -> jumlah = AttributeTotal.JUMLAH[position].value
        }
        updateBuah()
    }

    fun drawableSelected(drawable: Int) {
        this.drawable = drawable
        updateBuah()
    }

    fun saveBuah() {
        return if (checkField()) {
            repository.saveBuah(creature)
            saveLiveData.postValue(true)
        } else {
            saveLiveData.postValue(false)
        }
    }

    fun checkField(): Boolean {
        return jumlah != 0 && name.isNotEmpty() && !name.trim().isEmpty() && drawable != 0
    }
}