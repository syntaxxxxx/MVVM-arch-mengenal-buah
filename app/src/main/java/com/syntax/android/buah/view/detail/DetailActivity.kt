
package com.syntax.android.buah.view.detail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.syntax.android.buah.R
import com.syntax.android.buah.model.AttributeTotal
import com.syntax.android.buah.model.AttributeType
import com.syntax.android.buah.model.AttributeValue
import com.syntax.android.buah.model.BuahParam
import com.syntax.android.buah.view.dialog_fragment.BuahAdapter
import com.syntax.android.buah.view.dialog_fragment.BuahDialogFragment
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_buah.*
import org.jetbrains.anko.toast

class DetailActivity : AppCompatActivity(), BuahAdapter.BuahListener {

  private lateinit var viewModel: DetailViewModel


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView( R.layout.activity_detail)

    viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)

    configureUI()
    configureSpinnerAdapters()
    configureSpinnerListeners()
    configureEditText()
    configureClickListeners()
    configureLiveDataObservers()

    btn_save.setOnClickListener {
      viewModel.saveBuah()
    }
  }

  private fun configureUI() {
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    title = "detail buah"
    if (viewModel.drawable != 0) hideKlik()
  }

  private fun configureSpinnerAdapters() {
    jumlah.adapter = ArrayAdapter<AttributeValue>(this,
        android.R.layout.simple_spinner_dropdown_item, AttributeTotal.JUMLAH)
  }

  private fun configureSpinnerListeners() {
    jumlah.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
      override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        viewModel.attributeSelected(AttributeType.JUMLAH, position)
      }
      override fun onNothingSelected(parent: AdapterView<*>?) {}
    }
  }

  private fun configureEditText() {
    edt_name_buah.addTextChangedListener(object : TextWatcher {
      override fun afterTextChanged(s: Editable?) {}
      override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
      override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        viewModel.name = s.toString()
      }
    })
  }

  private fun configureClickListeners() {
    iv_klik.setOnClickListener {
      val bottomDialogFragment = BuahDialogFragment.newInstance()
      bottomDialogFragment.show(supportFragmentManager, "BuahDialogFragment")
    }
  }

  private fun configureLiveDataObservers() {
    viewModel.getBuahLiveData().observe(this, Observer { buah ->
      buah?.let {
        iv_klik.setImageResource(buah.drawable)
        edt_name_buah.setText(buah.name)
      }
    })
    viewModel.getSaveLiveData().observe(this, Observer { saved ->
      saved?.let {
        if (saved) {
          toast("berhasil")
          finish()
        } else {
          toast("harus di isi semua")
        }
      }
    })
  }

  override fun buahClicked(buahParam: BuahParam) {
    viewModel.drawableSelected(buahParam.drawable)
    hideKlik()
  }

  private fun hideKlik() {
    tv_klik.visibility = View.INVISIBLE
  }
}
