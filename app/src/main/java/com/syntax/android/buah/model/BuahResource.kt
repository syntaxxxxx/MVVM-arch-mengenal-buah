
package com.syntax.android.buah.model

import com.syntax.android.buah.R
import com.syntax.android.buah.model.BuahParam

object BuahResource {
  val BUAH_PARAMS: List<BuahParam> by lazy {
    val buah = mutableListOf<BuahParam>()

    buah.add(BuahParam(R.drawable.alpukat))
    buah.add(BuahParam(R.drawable.apel))
    buah.add(BuahParam(R.drawable.ceri))
    buah.add(BuahParam(R.drawable.durian))
    buah.add(BuahParam(R.drawable.jambuair))
    buah.add(BuahParam(R.drawable.manggis))
    buah.add(BuahParam(R.drawable.strawberry))

    buah
  }
}