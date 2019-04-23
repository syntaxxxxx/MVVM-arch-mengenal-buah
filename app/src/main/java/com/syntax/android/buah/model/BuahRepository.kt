
package com.syntax.android.buah.model

import android.arch.lifecycle.LiveData

interface BuahRepository {
  fun saveBuah(creature: Buah)
  fun getAllBuah(): LiveData<List<Buah>>
  fun deleteAllBuah()
}