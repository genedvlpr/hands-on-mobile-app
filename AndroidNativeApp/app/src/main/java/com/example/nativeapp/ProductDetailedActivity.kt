package com.example.nativeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.nativeapp.model.ProductModel

class ProductDetailedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detailed_view)

        val detailedProductName: TextView = findViewById(R.id.detailedProductName)
        val detailedProductPrice: TextView = findViewById(R.id.detailedProductPrice)

        var product = intent.getStringArrayExtra("PRODUCT")
        product?.let { array ->
            val displayText = "Received Array:\n${array.joinToString("\n")}"
            detailedProductName.text = array[0]
            detailedProductPrice.text = "Price: Php ${array[1]}"
        } ?: run {
            detailedProductName.text = "No data"
            detailedProductPrice.text = "No data"
        }
    }
}