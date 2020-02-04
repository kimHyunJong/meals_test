package com.example.testapplication.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.testapplication.IngredientModel
import com.example.testapplication.R
import com.example.testapplication.adapter.IngredientAdapter
import com.example.testapplication.view_holder.IngredientViewHolder
import kotlinx.android.synthetic.main.fragment_ingredient_meat.*

class MeatFragment : Fragment(), IngredientViewHolder.ItemClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ingredient_meat, container, false)
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


    fun genIngredientList(): List<IngredientModel> {

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
