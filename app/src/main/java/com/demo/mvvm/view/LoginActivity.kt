package com.demo.mvvm.view

import android.arch.lifecycle.Observer
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.demo.mvvm.MainActivity
import com.demo.mvvm.R
import com.demo.mvvm.databinding.ActivityLoginBinding
import com.demo.mvvm.viewmodel.LoginViewModel

/**
 *  Create by ThanhPQ
 */
class LoginActivity : AppCompatActivity() {
    private var viewModel: LoginViewModel = LoginViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        activityMainBinding.apply {
            viewModel = viewModel
            executePendingBindings()
        }

        observeField()
    }

    private fun observeField() {
        viewModel.isLoginSuccess.observe(this, Observer { isLogin ->
            if (isLogin != null) {
                startMain(isLogin)
            }
        })
    }

    private fun startMain(isLogin: Boolean) = if (isLogin) {
        startActivity(Intent(this, MainActivity::class.java))
    } else {
        Toast.makeText(this, "Login fail!", Toast.LENGTH_LONG).show()
    }
}