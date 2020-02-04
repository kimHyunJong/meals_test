package com.example.testapplication.fragment


import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat.invalidateOptionsMenu
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.testapplication.IngredientModel
import com.example.testapplication.R
import com.example.testapplication.adapter.IngredientAdapter
import com.example.testapplication.adapter.IngredientsPagerAdapter
import com.example.testapplication.view_holder.IngredientViewHolder
import com.google.android.material.tabs.TabLayoutMediator
import com.orhanobut.logger.Logger
import kotlinx.android.synthetic.main.fragment_ingredient_meat.*
import kotlinx.android.synthetic.main.fragment_ingredients.*


/**
 * 食材選択Container
 * */
class IngredientsFragment : Fragment() {
    private var mMenu: Menu? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_ingredients, container, false)
    }

    /* override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
         super.onCreateOptionsMenu(menu, inflater)
         inflater.inflate(R.menu.ingredient_menu, menu)
     }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pagerAdapter =
            IngredientsPagerAdapter(
                this,
                3
            )

        ingredientsPager.adapter = pagerAdapter

        ingredientsPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                Logger.d("")
                invalidateOptionsMenu(activity)

            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Logger.d("")
            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
                Logger.d("")
            }
        })

        TabLayoutMediator(ingredientChooseTabs, ingredientsPager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = getTabName(position)
            }).attach()
    }


    private fun getTabName(_position: Int): String {
        return when (_position) {
            0 -> {
                "人気"
            }
            1 -> {
                "肉"
            }
            else -> {
                "魚"
            }
        }
    }


}

/**
 * 人気
 * */
class IngredientPopularFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ingredient_popular, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun newInstance() = IngredientPopularFragment()
    }
}

/**
 * 肉
 * */
class IngredientMeatFragment : Fragment(), IngredientViewHolder.ItemClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val fhfh = 222
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_ingredient_meat, container, false)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.ingredient_menu, menu)
        val fhfh = 222


    }

    override fun onPrepareOptionsMenu(menu: Menu) {
        super.onPrepareOptionsMenu(menu)
        val fhfh = 222
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rcv_meat.adapter = IngredientAdapter(
            context!!,
            this,
            genIngredientList()
        )
        val layoutManager = GridLayoutManager(context, 3)
        rcv_meat.layoutManager = layoutManager

    }


    companion object {
        @JvmStatic
        fun newInstance() = MeatFragment()
    }

    override fun onItemClick(view: View, position: Int) {

        val isChecked = view.findViewById<ImageView>(R.id.img_check)
        if (isChecked.isVisible) {
            isChecked.visibility = View.INVISIBLE

        } else {
            isChecked.visibility = View.VISIBLE
        }

        Toast.makeText(context, "$view>>>$position", Toast.LENGTH_SHORT).show()
    }


    private fun genIngredientList(): List<IngredientModel> {

        val ingredientList = mutableListOf<IngredientModel>()
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
                IngredientModel(
                    i,
                    title = title[index]
                )
            )
        }

        return ingredientList

    }
}

/**
 * 魚
 * */
class IngredientFishFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ingredient_fish, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        @JvmStatic
        fun newInstance() = IngredientFishFragment()
    }
}


