package com.utad.listacompra

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"



/**
 * A simple [Fragment] subclass.
 * Use the [List.newInstance] factory method to
 * create an instance of this fragment.
 */
class List : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var adapter: FoodAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var foodArrayList : ArrayList<Food>

    lateinit var imageId : Array<Int>
    lateinit var foodName : Array<String>
    lateinit var foodPrice : Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment List.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            List().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.RecyclerViewList)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = FoodAdapter(foodArrayList)
        recyclerView.adapter = adapter
    }



    private fun dataInitialize() {

        foodArrayList = arrayListOf<Food>()

        imageId = arrayOf(
            R.drawable.pan2,
            R.drawable.cereales,
            R.drawable.leche,
            R.drawable.huevos,
            R.drawable.chocolate,
            R.drawable.carne,
            R.drawable.pescado,
            R.drawable.mantequilla
        )

        foodName = arrayOf(
            getString(R.string.food_a),
            getString(R.string.food_b),
            getString(R.string.food_c),
            getString(R.string.food_d),
            getString(R.string.food_e),
            getString(R.string.food_f),
            getString(R.string.food_g),
            getString(R.string.food_h)
        )

        foodPrice = arrayOf(
            getString(R.string.price_a),
            getString(R.string.price_b),
            getString(R.string.price_c),
            getString(R.string.price_d),
            getString(R.string.price_e),
            getString(R.string.price_f),
            getString(R.string.price_g),
            getString(R.string.price_h)
        )

        for (i in imageId.indices) {

            val food = Food(imageId[i],foodName[i],foodPrice[i])
            foodArrayList.add(food)
        }


    }
}