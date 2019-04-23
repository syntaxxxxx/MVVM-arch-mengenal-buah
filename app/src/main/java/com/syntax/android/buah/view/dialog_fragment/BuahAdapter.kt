
package com.syntax.android.buah.view.dialog_fragment

import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.syntax.android.buah.R
import com.syntax.android.buah.app.inflate
import com.syntax.android.buah.model.BuahParam

class BuahAdapter(private val buah: List<BuahParam>, private val listener: BuahListener)
  : RecyclerView.Adapter<BuahAdapter.ViewHolder>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
    return ViewHolder(parent.inflate(R.layout.item_buah_dialogg))
  }

  override fun getItemCount() = buah.size

  override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.bind(buah[position])
  }

  inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private lateinit var buahParam: BuahParam

    private val imageView = itemView.findViewById<ImageView>(R.id.iv_item_buah_dialog)

    init {
      itemView.setOnClickListener(this)
    }

    fun bind(buah: BuahParam) {
      this.buahParam = buah
      val bitmap = BitmapFactory.decodeResource(imageView.context.resources, buahParam.drawable)
      imageView.setImageDrawable(BitmapDrawable(imageView.context.resources, bitmap))
    }

    override fun onClick(view: View) {
      listener.buahClicked(this.buahParam)
    }
  }

  interface BuahListener {
    fun buahClicked(buahParam: BuahParam)
  }
}