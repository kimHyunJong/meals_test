package com.example.testapplication.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.testapplication.FAVORITE
import com.example.testapplication.INGREDIENT
import com.example.testapplication.fragment.IngredientFishFragment
import com.example.testapplication.fragment.IngredientMeatFragment
import com.example.testapplication.fragment.IngredientPopularFragment
import com.example.testapplication.fragment.MealsMenuItemFragment


/**
 * 食材選択用のPagerAdapter
 * */
class IngredientsPagerAdapter(fragment: Fragment, private val pageCount: Int) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = pageCount

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> {
                return IngredientPopularFragment.newInstance()
            }
            1 -> {
                return IngredientMeatFragment.newInstance()
            }
            2 -> {

                return IngredientFishFragment.newInstance()
            }
        }

        return IngredientPopularFragment.newInstance()
    }


}

/**
 *
 *
 * */
class MealsMenuListPagerAdapter(fragment: Fragment, private val pageCount: Int) :
    FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = pageCount

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) {
            MealsMenuItemFragment.newInstance(INGREDIENT)
        } else {
            MealsMenuItemFragment.newInstance(FAVORITE)
        }
    }


}