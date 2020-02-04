package com.example.testapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.IngredientModel
import com.example.testapplication.MealsMenuModel
import com.example.testapplication.R
import com.example.testapplication.view_holder.IngredientViewHolder
import com.example.testapplication.view_holder.MealsMenusViewHolder

/**
 *
 * */
class IngredientAdapter(
    private val context: Context,
    private val itemClickLsn: IngredientViewHolder.ItemClickListener,
    private val ingredients: List<IngredientModel>
) :
    RecyclerView.Adapter<IngredientViewHolder>() {

    private var mRecyclerView: RecyclerView? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        mRecyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        mRecyclerView = null
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val mView = layoutInflater.inflate(R.layout.item_ingredient, parent, false)

        mView.setOnClickListener { view ->
            mRecyclerView?.let {
                itemClickLsn.onItemClick(view, it.getChildAdapterPosition(view))
            }
        }

        return IngredientViewHolder(mView)
    }

    override fun getItemCount(): Int {
        return ingredients.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) {
            0
        } else {
            1
        }

    }

    override fun onBindViewHolder(holder: IngredientViewHolder, position: Int) {
        holder.let {
            it.mImg.setImageResource(ingredients[position].image)
            it.mTitle.text = ingredients[position].title
        }
    }
}


/**
 *
 * */
class MealsMenuAdapter(
    private val context: Context,
    private val itemClickLsn: MealsMenusViewHolder.ItemClickListener,
    private val ingredients: List<MealsMenuModel>
) :
    RecyclerView.Adapter<MealsMenusViewHolder>() {

    private var mRecyclerView: RecyclerView? = null

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        mRecyclerView = recyclerView
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        mRecyclerView = null
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealsMenusViewHolder {

        val layoutInflater = LayoutInflater.from(context)
        val mView = layoutInflater.inflate(R.layout.item_meals_menu, parent, false)

        mView.setOnClickListener { view ->
            mRecyclerView?.let {
                itemClickLsn.onItemClick(view, it.getChildAdapterPosition(view))
            }
        }

        return MealsMenusViewHolder(mView)
    }

    override fun getItemCount(): Int {
        return ingredients.size
    }

    override fun onBindViewHolder(holder: MealsMenusViewHolder, position: Int) {
        holder.let {
            it.mImg.setImageResource(ingredients[position].image)
            it.mTitle.text = ingredients[position].title
        }
    }
}