package com.example.nativeapp;

import android.content.Context;
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

import com.example.nativeapp.model.ProductModel;

class CustomAdapter(context:Context, private val itemList: List<ProductModel>) : BaseAdapter(){

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return itemList.count()
    }

    override fun getItem(position: Int): Any {
        return itemList[position]
    }

    override fun getItemId(position: Int): Long {
       return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val holder: ViewHolder

        if (convertView == null){
            view = inflater.inflate(R.layout.main_list_item, parent, false)
            holder = ViewHolder(view)
            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val currentItem = getItem(position) as ProductModel

        holder.productName.text = currentItem.getProductName()
        holder.productPrice.text = "Php ${currentItem.getProductPrice()}"

        return view
    }

    private class ViewHolder(view: View){
        val productName = view.findViewById<TextView>(R.id.product_name)
        val productPrice = view.findViewById<TextView>(R.id.product_price)
    }
}
