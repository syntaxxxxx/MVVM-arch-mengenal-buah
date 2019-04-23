package com.syntax.android.buah.view.utama

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.syntax.android.buah.R
import com.syntax.android.buah.view.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content.*

class MainActivity : AppCompatActivity() {

  private lateinit var viewModel: MainViewModel

  private val adapter = MainAdapter(mutableListOf())

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    setSupportActionBar(toolbar)

    configViewModel()
    configList()
    configLiveDataObservers()
    configFabListener()
  }

  private fun configViewModel() {
    viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
  }

  private fun configList() {
    recyclerview.layoutManager = LinearLayoutManager(this)
    recyclerview.adapter = adapter
  }

  private fun configLiveDataObservers() {
    viewModel.getAllCreaturesLiveData().observe(this, Observer { creatures ->
      creatures?.let {
        adapter.updateCreatures(creatures)
      }
    })
  }

  private fun configFabListener() {
    fab.setOnClickListener {
      startActivity(Intent(this, DetailActivity::class.java))
    }
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    // Inflate the menu; this adds items to the action bar if it is present.
    menuInflater.inflate(R.menu.menu_main, menu)
    return true
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    return when (item.itemId) {
      R.id.delete -> {
        viewModel.clearAllCreatures()
        true
      }
      else -> super.onOptionsItemSelected(item)
    }
  }
}
