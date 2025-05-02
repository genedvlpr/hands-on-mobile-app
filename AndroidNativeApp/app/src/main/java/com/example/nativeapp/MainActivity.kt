package com.example.nativeapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import com.example.nativeapp.model.ProductModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var productNameLayout: TextInputLayout = findViewById(R.id.productNameLayout)
        var productNameEditText: TextInputEditText = findViewById(R.id.productNameEditText)
        var productPriceLayout: TextInputLayout = findViewById(R.id.productPriceLayout)
        var productPriceEditText: TextInputEditText = findViewById(R.id.productPriceEditText)

        var addItemBtn: Button = findViewById(R.id.addItemBtn)

        val listView : ListView = findViewById<ListView>(R.id.main_list)

        val products = mutableListOf<ProductModel>(
            ProductModel(productName = "Item 1", productPrice = 10),
            ProductModel(productName = "Item 2", productPrice = 20),
            ProductModel(productName = "Item 3", productPrice = 30),
        )

        val adapter = CustomAdapter(this, products)

        listView.adapter = adapter

        addItemBtn.setOnClickListener {
            products.add(
                ProductModel(
                    productName = productNameEditText.text.toString(),
                    productPrice = productPriceEditText.text.toString().toInt()
                )
            )

            listView.adapter = adapter
        }

        listView.setOnItemClickListener{ parent, view, position, id ->
            val selectedItem = products[position]
            val detailedIntent = Intent(this, ProductDetailedActivity::class.java)
//            Toast.makeText(this, "Clicked: $selectedItem at position $position", Toast.LENGTH_SHORT).show()

            detailedIntent.putExtra("PRODUCT",
                arrayOf(selectedItem.getProductName(), selectedItem.getProductPrice().toString())
            )
            startActivity(detailedIntent)
        }
    }
}