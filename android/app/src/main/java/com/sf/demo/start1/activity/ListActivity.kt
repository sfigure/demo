package com.sf.demo.start1.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.sf.demo.start1.R
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ArrayAdapter
import com.sf.demo.start1.activity.Adapter.ListAdapter
import kotlinx.android.synthetic.main.activity_list.*


class ListActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        this.recyclerview1.adapter=ListAdapter(getData())
    }

    private fun getData(): List<Int> {
        return listOf(1,3,4,5);
    }
}
