
package com.syntax.android.buah.model.room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.syntax.android.buah.model.Buah

@Database(entities = [(Buah::class)], version = 1)
@TypeConverters(BuahConverter::class)
abstract class BuahDatabase : RoomDatabase() {
  abstract fun creatureDao(): BuahDao
}