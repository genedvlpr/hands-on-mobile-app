package com.example.nativeapp.model

class ProductModel(private var productName: String, private var productPrice: Int) {

    fun setProductName(pName: String) {
        productName = pName
    }

    fun getProductName(): String {
        return productName
    }

    fun setProductPrice(pPrice: Int) {
        productPrice = pPrice
    }

    fun getProductPrice(): Int {
        return productPrice
    }
}