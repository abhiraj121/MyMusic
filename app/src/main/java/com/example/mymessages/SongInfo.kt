package com.example.mymessages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_song_info.*

class SongInfo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song_info)

        var bundle: Bundle? = intent.extras
        var name = bundle?.getString("name")
        var artist = bundle?.getString("artist")
        var image = bundle!!.getInt("image")
        var heart = bundle!!.getBoolean("heart")

        imageView2.setImageResource(image)
        SName.text = name
        AName.text = artist
        if (heart == true) {
            imageView3.setImageResource(R.drawable.ic_favorite_black_24dp)
        }else{
            imageView3.setImageResource(R.drawable.notfavorite)
        }

    }
}
