package com.example.gridview

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.google.gson.Gson
import kotlinx.android.synthetic.main.item_layout.view.*

class TinderAdapter : BaseAdapter {
    var tinders = ArrayList<Model>()
    var context: Context? = null

    constructor(context: Context, tinders: ArrayList<Model>) : super() {
        this.context = context
        this.tinders = tinders
    }

    override fun getCount(): Int {
        return tinders.size
    }

    override fun getItem(position: Int): Any {
        return tinders[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val tinder = this.tinders[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var tinderView = inflator.inflate(R.layout.item_layout, null)
        tinderView.imageView.setImageResource(tinder.image)
        tinderView.tvName.text = tinder.name
        tinderView.ratingBar1.rating = tinder.rate.toFloat()
        tinderView.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("id",tinders[position].id)
            intent.putExtra("info", tinders[position].info)
            intent.putExtra("rate", tinders[position].rate)
            intent.putExtra("image", tinders[position].image)
            context?.startActivity(intent)
        }
        return tinderView
    }
}