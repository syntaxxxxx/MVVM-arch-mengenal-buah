
package com.syntax.android.buah.view.dialog_fragment

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v7.widget.GridLayoutManager
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.syntax.android.buah.R
import com.syntax.android.buah.model.BuahParam
import com.syntax.android.buah.model.BuahResource
import kotlinx.android.synthetic.main.item_dialog_bottom.*


class BuahDialogFragment : BottomSheetDialogFragment(), BuahAdapter.BuahListener {

  private lateinit var callback: BuahAdapter.BuahListener

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.item_dialog_bottom, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    recyclerview_dialog.layoutManager = GridLayoutManager(context, 2)
    recyclerview_dialog.adapter = BuahAdapter(BuahResource.BUAH_PARAMS, this)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)

    try {
      callback = activity as BuahAdapter.BuahListener
    } catch (e: java.lang.ClassCastException) {
      throw ClassCastException(activity.toString())
    }
  }

  override fun buahClicked(buahParam: BuahParam) {
    callback.buahClicked(buahParam)
  }

  companion object {
    fun newInstance(): BuahDialogFragment {
      return BuahDialogFragment()
    }
  }
}