package com.sf.demo.start1.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import com.sf.demo.start1.R
import com.sf.demo.start1.controller.UserController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    public var user = UserController();

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //退出登录
        this.button.setOnClickListener {
            if(user.logout()){

                intent.setClass(this,LoginActivity::class.java);
                startActivity(intent)
            }
        }
        this.button3.setOnClickListener {
                intent.setClass(this,ListActivity::class.java);
                startActivity(intent)
        }
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
}
