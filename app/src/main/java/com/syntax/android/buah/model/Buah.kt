
package com.syntax.android.buah.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.support.annotation.NonNull

@Entity(tableName = "buah_table")
data class Buah(
        val attributes: BuahAttribute = BuahAttribute(),
        val totalBuah: Int = 0,
        @PrimaryKey @NonNull val name: String,
        val drawable: Int = 0
)