
package com.syntax.android.buah.view.utama

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.syntax.android.buah.R
import com.syntax.android.buah.app.inflate
import com.syntax.android.buah.model.Buah
import kotlinx.android.synthetic.main.item_buah.view.*

class MainAdapter(private val creatures: MutableList<Buah>)
  : RecyclerView.Adapter<MainAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(parent.inflate(R.layout.item_buah))
  }

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(creatures[position])
  }

  override fun getItemCount() = creatures.size

  fun updateCreatures(creatures: List<Buah>) {
    this.creatures.clear()
    this.creatures.addAll(creatures)
    notifyDataSetChanged()
  }

  class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private lateinit var buah: Buah

    fun bind(buah: Buah) {
      this.buah = buah
      itemView.avatarListItem.setImageDrawable(itemView.context.resources.getDrawable(buah.drawable))
      itemView.tv_name_buah.text = buah.name
      itemView.tv_jumlah.text = buah.totalBuah.toString()
    }
  }
}