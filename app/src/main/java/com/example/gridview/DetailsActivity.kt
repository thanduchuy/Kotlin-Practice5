package com.example.gridview

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.Menu
import android.view.MenuItem
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_details.*


class DetailsActivity : AppCompatActivity(), RatingBar.OnRatingBarChangeListener {
    var id: String = ""
    var info: String = ""
    var rate: String = ""
    var image: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        supportActionBar?.show()
        val bundle: Bundle? = intent.extras
        bundle?.let {
            id = bundle.get("id").toString()
            info = bundle.get("info").toString()
            rate = bundle.get("rate").toString()
            image = bundle.get("image").toString()

            textView2.text = info
            ratingBar4.rating = rate.toFloat()
            imageView2.setImageResource(image.toInt())
        }
        ratingBar4.onRatingBarChangeListener = this
    }
    fun saveArrayList(list: ArrayList<Model>, key: String?) {
        val sharedPref: SharedPreferences = getSharedPreferences("list", 0)
        val editor: SharedPreferences.Editor = sharedPref.edit()
        val gson = Gson()
        val json: String = gson.toJson(list)
        editor.putString(key, json)
        editor.apply()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }
    override fun onRatingChanged(p0: RatingBar?, p1: Float, p2: Boolean) {
        val rating = p1
        for (item in Supplier.data) {
            if (item.id == id.toInt()) {
                item.rate = p1.toInt()
            }
        }
        saveArrayList(Supplier.data,"list")
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id = item.itemId
        if (id == R.id.btnShare) {
            var intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,info)
            intent.type = "text/plain"
            startActivity(Intent.createChooser(intent,"Share to"))
            return true
        } else if (id == R.id.btnCreate) {
            Toast.makeText(this,"Create my Profile",Toast.LENGTH_SHORT).show()
            return true
        } else {
            onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }
}
