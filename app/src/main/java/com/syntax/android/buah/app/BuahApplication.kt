
package com.syntax.android.buah.app

import android.app.Application
import android.arch.persistence.room.Room
import com.syntax.android.buah.model.room.BuahDatabase

class BuahApplication : Application() {

  companion object {
    lateinit var database: BuahDatabase
  }

  override fun onCreate() {
    super.onCreate()

    database = Room.databaseBuilder(this, BuahDatabase::class.java, "buah_database")
        .build()
  }
}