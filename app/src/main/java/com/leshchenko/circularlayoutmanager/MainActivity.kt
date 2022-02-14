package com.leshchenko.circularlayoutmanager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.leshchenko.circularlayoutmanagerlib.ACurve
import com.leshchenko.circularlayoutmanagerlib.CurveLayoutManger
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToInt


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val curveLayoutManger = CurveLayoutManger(ACurve(),this)
        circularRecycler.layoutManager = curveLayoutManger
        circularRecycler.adapter = Adapter()


        circularRecycler.postDelayed({
            circularRecycler.smoothScrollBy(100*20, circularRecycler.bottom)
        },500)
    }


    inner class Adapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false))


        override fun getItemCount() = 20

        override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
            holder.itemView.setOnClickListener {
                circularRecycler.postDelayed({
                    circularRecycler.smoothScrollBy(it.x.roundToInt(), it.y.roundToInt())
                },2500)
            }
        }

        inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view)

    }

}
