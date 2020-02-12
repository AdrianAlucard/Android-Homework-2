package com.example.hw2_pizzaorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.Switch
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToInt
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity() {
    private var total: Double = 0.0
    private var extras: Double = 0.0
    private var pizzaCost: Double = 9.99

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setPizzaSelectListener()
        calcTotal()
    }

    fun pizzaSizeClick(view: View) {
        pizzaCost = when(view.id){
            R.id.medium -> 9.99
            R.id.large -> 13.99
            else -> 15.99
        }
        calcTotal()
    }

    fun deliveryClick(view: View) {
        val switch = findViewById<Switch>(view.id)
        when(switch.isChecked) {
            true -> extras+=2
            else -> extras-=2
        }
        calcTotal()
    }

    fun extraToppingsClick(view: View) {
        val checkBox = findViewById<CheckBox>(view.id)
        when(checkBox.isChecked) {
            true -> extras+=1.69
            else -> extras-=1.69
        }
        calcTotal()
    }

    private fun calcTotal() {
        total = pizzaCost + extras
        total_text.text = "Total: $${String.format("%.2f", total)}"
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
