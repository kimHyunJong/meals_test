package com.example.testapplication.fragment


import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testapplication.MEALS_MENU_RECOMMEND
import com.example.testapplication.MealsMenuModel
import com.example.testapplication.R
import com.example.testapplication.adapter.MealsMenuAdapter
import com.example.testapplication.view_holder.MealsMenusViewHolder
import kotlinx.android.synthetic.main.fragment_meals_menu_item.*

/**
 * A simple [Fragment] subclass.
 */
class MealsMenuItemFragment : Fragment(), MealsMenusViewHolder.ItemClickListener {

    private var mPageName: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            mPageName = it.getInt(MEALS_MENU_RECOMMEND)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_meals_menu_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (mPageName == 0) {
            tvMealsMenuTitle.text = "食材＞＞＞美味しい肉！！"
            tvMealsMenuTitle.setTextColor(Color.WHITE)
        } else {
            tvMealsMenuTitle.text = "人気＞＞＞美味しい肉！！"
            tvMealsMenuTitle.setTextColor(Color.WHITE)
        }


    }


    companion object {
        @JvmStatic
        fun newInstance(_pageName: Int) =
            MealsMenuItemFragment().apply {
                arguments = Bundle().apply {
                    putInt(MEALS_MENU_RECOMMEND, _pageName)
                }
            }
    }

    override fun onItemClick(view: View, position: Int) {

    }

    fun genIngredientList(): List<MealsMenuModel> {

        val ingredientList = mutableListOf<MealsMenuModel>()
        val img = listOf(
            R.drawable.carrot,
            R.drawable.chicken,
            R.drawable.egg,
            R.drawable.fish,
            R.drawable.ketchup,
            R.drawable.mayo,
            R.drawable.meat,
            R.drawable.milk,
            R.drawable.onion
        )

        val title =
            listOf("carrot", "chicken", "egg", "fish", "ketchup", "mayo", "meat", "milk", "onion")


        img.forEachIndexed { index, i ->
            ingredientList.add(
                MealsMenuModel(
                    i,
                    title = title[index]
                )
            )
        }

        return ingredientList

    }
}
