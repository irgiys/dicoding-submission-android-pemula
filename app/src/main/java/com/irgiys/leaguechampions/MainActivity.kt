package com.irgiys.leaguechampions

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvChamp: RecyclerView
    private val list = ArrayList<Champ>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvChamp = findViewById(R.id.rv_champ)
        rvChamp.setHasFixedSize(true)

        list.addAll(getListChamp())
        showRecyclerList()

    }

    fun openAboutActivity(view: View) {
        val intent = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(intent)
    }

    private fun getListChamp(): ArrayList<Champ> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataQuotes = resources.getStringArray(R.array.data_quotes)
        val dataThumbnail = resources.obtainTypedArray(R.array.data_thumbanail)
        val dataJumbo = resources.obtainTypedArray(R.array.data_jumbo)

        val listChamp = ArrayList<Champ>()

        for (i in dataName.indices) {
            val champ = Champ(
                dataName[i],
                dataDescription[i],
                dataThumbnail.getResourceId(i, -1),
                dataQuotes[i],
                dataJumbo.getResourceId(i, -1)
            )
            listChamp.add(champ)
        }

        return listChamp
    }

    private fun showRecyclerList() {

        val showLayout =
            if (this.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                GridLayoutManager(this, 2)
            } else {
                LinearLayoutManager(this)
            }

        rvChamp.layoutManager = showLayout
        val listChampAdapter = ListChampAdapter(list)
        rvChamp.adapter = listChampAdapter
    }
}