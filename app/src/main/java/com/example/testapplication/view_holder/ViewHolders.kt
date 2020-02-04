package com.example.testapplication.view_holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.R

class IngredientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    val mImg: ImageView = itemView.findViewById(
        R.id.img_ingredients
    )

    val mTitle: TextView = itemView.findViewById(
        R.id.tv_title
    )

}

class MealsMenusViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    val mImg: ImageView = itemView.findViewById(
        R.id.imgMealsMenuItem
    )

    val mTitle: TextView = itemView.findViewById(
        R.id.tvMealsMenuItem
    )

}