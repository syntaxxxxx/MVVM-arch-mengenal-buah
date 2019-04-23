
package com.syntax.android.buah.model.room

import android.arch.lifecycle.LiveData
import android.os.AsyncTask
import com.syntax.android.buah.app.BuahApplication
import com.syntax.android.buah.model.Buah
import com.syntax.android.buah.model.BuahRepository

class RoomRepository : BuahRepository {
  private val buahDao: BuahDao = BuahApplication.database.creatureDao()
  private val allCreatures: LiveData<List<Buah>>

  init {
    allCreatures = buahDao.getAllCreatures()
  }

  override fun saveBuah(creature: Buah) {
    InsertAsyncTask(buahDao).execute(creature)
  }

  override fun getAllBuah() = allCreatures

  override fun deleteAllBuah() {
    val creatureArray = allCreatures.value?.toTypedArray()
    if (creatureArray != null) {
      DeleteAsyncTask(buahDao).execute(*creatureArray)
    }
  }

  private class InsertAsyncTask internal constructor(private val dao: BuahDao) : AsyncTask<Buah, Void, Void>() {
    override fun doInBackground(vararg params: Buah): Void? {
      dao.insert(params[0])
      return null
    }
  }

  private class DeleteAsyncTask internal constructor(private val dao: BuahDao) : AsyncTask<Buah, Void, Void>() {
    override fun doInBackground(vararg params: Buah): Void? {
      dao.clearCreatures(*params)
      return null
    }
  }
}