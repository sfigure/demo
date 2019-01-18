package com.sf.demo.start1.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View.VISIBLE
import android.widget.Toast
import com.sf.demo.start1.R
import com.sf.demo.start1.controller.UserController
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    var user = UserController();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        this.button2.setOnClickListener {
            this.progressBar2.visibility = VISIBLE
            if (user.loginByPassword(this.editText3.text.toString(), this.editText4.text.toString())) {
                intent.setClass(this, MainActivity::class.java);
                this.startActivity(intent)
                this.finish()

            } else {
                Toast.makeText(this, "用户名密码错误", Toast.LENGTH_LONG).show();
            }
        }
    }


}
