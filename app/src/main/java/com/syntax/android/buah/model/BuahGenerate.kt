
package com.syntax.android.buah.model


class BuahGenerate {
  fun generateCreature(attributes: BuahAttribute, name: String = "", drawable: Int = 0): Buah {
    val hitPoints = attributes.jumlahBuah
    return Buah(attributes, hitPoints, name, drawable)
  }
}