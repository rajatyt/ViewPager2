package com.example.poccrousal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class AdapterClass(private var imageList:ArrayList<Int>,private val viewPager2: ViewPager2):RecyclerView.Adapter<AdapterClass.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.card,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(imageList[position])
        if(position==imageList.size-1){
            viewPager2.post(runnable)
        }
    }
    inner class ViewHolder(var itemView: View):RecyclerView.ViewHolder(itemView) {
        val imageView:ImageView=itemView.findViewById(R.id.imageView)

        fun bind(image:Int){
            imageView.setImageResource(image)
        }
    }
    val runnable= Runnable {
        imageList.addAll(imageList)
        notifyDataSetChanged()
    }

}