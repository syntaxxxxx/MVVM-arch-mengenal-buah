
package com.syntax.android.buah.model.room

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.syntax.android.buah.model.Buah

@Dao
interface BuahDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insert(creature: Buah)

  @Delete
  fun clearCreatures(vararg creature: Buah)

  @Query("SELECT * FROM buah_table ORDER BY name ASC")
  fun getAllCreatures(): LiveData<List<Buah>>
}