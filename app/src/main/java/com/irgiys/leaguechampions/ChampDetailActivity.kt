package com.irgiys.leaguechampions

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar


class ChampDetailActivity : AppCompatActivity() {

    companion object {
        const val KEY_CHAMP = "key_champ"
    }

    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_champ_detail)

        val dataChamp = intent.getParcelableExtra<Champ>(KEY_CHAMP)!!

        val tvQuotes : TextView = findViewById(R.id.tv_quotes)
        val tvDetailName : TextView = findViewById(R.id.tv_detail_name)
        val tvDetailDescription : TextView = findViewById(R.id.tv_detail_description)
        val ivThumbPhoto : ImageView = findViewById(R.id.iv_detail_photo)
        val wtJumbo : Toolbar = findViewById(R.id.toolbar)

        tvQuotes.text = "\"${dataChamp.quotes}\""
        tvDetailName.text = "~${dataChamp.name}"
        tvDetailDescription.text = dataChamp.description
        ivThumbPhoto.setImageResource(dataChamp.thumbnail)

        if (this.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            wtJumbo.setBackgroundResource(dataChamp.jumbo)
        }
    }

    @Suppress("DEPRECATION")
    fun onShareClicked(view: View) {

        val dataChamp = intent.getParcelableExtra<Champ>(KEY_CHAMP)!!
        val shareIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(
                Intent.EXTRA_TEXT,
                "Name: ${dataChamp.name} \nQuotes: ${dataChamp.quotes} \nDescription: ${dataChamp.description}"
            )
        }
        startActivity(Intent.createChooser(shareIntent, "Send to"))

    }

    @Suppress("DEPRECATION")
    fun onBackPressed(view: View) {
        onBackPressed()
    }

}