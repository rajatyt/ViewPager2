package com.example.poccrousal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var viewPager2: ViewPager2
    private lateinit var adapterClass: AdapterClass
    private lateinit var imageList:ArrayList<Int>
    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        viewPager2.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable,2000)
            }
        })


    }
private val runnable=Runnable{
    viewPager2.currentItem=viewPager2.currentItem+1
}
    fun init(){

        viewPager2=findViewById(R.id.viewPager)
        handler=Handler(Looper.myLooper()!!)
        imageList= ArrayList()

        imageList.add(R.drawable.one)
        imageList.add(R.drawable.three)
        imageList.add(R.drawable.two)

        viewPager2.adapter=AdapterClass(imageList,viewPager2)

        viewPager2.offscreenPageLimit=imageList.size-1
        viewPager2.clipToPadding=false
        viewPager2.clipChildren=false
        viewPager2.getChildAt(0).overScrollMode=RecyclerView.OVER_SCROLL_NEVER
    }
}