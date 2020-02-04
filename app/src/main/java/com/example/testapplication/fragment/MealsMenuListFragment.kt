package com.example.testapplication.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testapplication.R
import com.example.testapplication.adapter.MealsMenuListPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_meals_menu_list.*

/**
 * A simple [Fragment] subclass.
 */
class MealsMenuListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_meals_menu_list, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pagerAdapter =
            MealsMenuListPagerAdapter(
                this,
                2
            )

        meals_menu_list_pager.adapter = pagerAdapter
        TabLayoutMediator(meals_menu_list_tabs, meals_menu_list_pager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                when (position) {

                    0 -> {
                        tab.text = "食材"
                    }
                    1 -> {
                        tab.text = "人気"
                    }
                }
            }).attach()
    }
}
