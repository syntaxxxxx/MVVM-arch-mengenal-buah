
package com.syntax.android.buah.model.room

import android.arch.persistence.room.TypeConverter
import com.syntax.android.buah.model.BuahAttribute
import java.util.*

class BuahConverter {
  @TypeConverter
  fun fromCreatureAttributes(attributes: BuahAttribute?): String? {
    if (attributes != null) {
      return String.format(Locale.US, "%d", attributes.jumlahBuah)
    }
    return null
  }

  @TypeConverter
  fun toCreatureAttributes(value: String?): BuahAttribute? {
    if (value != null) {
      val pieces = value.split(",".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
      return BuahAttribute(
          java.lang.Integer.parseInt(pieces[0]))
    }
    return null
  }
}