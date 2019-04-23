package com.syntax.android.buah.model

object AttributeTotal {

    val JUMLAH: List<AttributeValue> by lazy {
        val buah = mutableListOf<AttributeValue>()
        buah.add(AttributeValue(0))
        buah.add(AttributeValue(1))
        buah.add(AttributeValue(2))
        buah.add(AttributeValue(3))
        buah.add(AttributeValue(4))
        buah.add(AttributeValue(5))

        buah
    }
}