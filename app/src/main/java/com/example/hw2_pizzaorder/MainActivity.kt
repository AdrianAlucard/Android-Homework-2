package com.example.hw2_pizzaorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var total: Number = 9.99

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setPizzaSelectListener()
    }

    private fun setPizzaSelectListener() {
        pizza_list.setOnItemClickListener{parent, view, position, id ->
            val imageId = when (parent.getItemAtPosition(position).toString()) {
                "BBQ Chicken" -> R.drawable.bbq_chicken
                "Pepperoni" -> R.drawable.pepperoni
                "Hawaiian" -> R.drawable.hawaiian
                else -> R.drawable.margheritta
            }
            pizza_image.setImageResource(imageId)
        }
    }
}
