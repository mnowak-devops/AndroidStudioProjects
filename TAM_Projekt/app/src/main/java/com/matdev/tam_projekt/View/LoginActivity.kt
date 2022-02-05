package com.matdev.tam_projekt.View

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.matdev.tam_projekt.Presenter.LoginInteractor
import com.matdev.tam_projekt.Presenter.LoginPresenter

class LoginActivity : AppCompatActivity(), LoginView {
    var etUsername: EditText? = null
    var etPassword: EditText? = null
    var progressbar: ProgressBar? = null
    var loginPresenter: LoginPresenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.matdev.tam_projekt.R.layout.activity_login)
        initViews()
        loginPresenter = LoginPresenter(this, LoginInteractor())
    }

    fun initViews() {
        etUsername = findViewById(com.matdev.tam_projekt.R.id.loginInput)
        etPassword = findViewById(com.matdev.tam_projekt.R.id.hasloInput)
        progressbar = findViewById(com.matdev.tam_projekt.R.id.progressbar)
    }

    public fun loginMe(view: View?) {
        showProgressbar()
        loginPresenter!!.validateCredentials(
            etUsername!!.text.toString().trim { it <= ' ' },
            etPassword!!.text.toString().trim { it <= ' ' })
    }

    override fun setUsernameError() {
        hideProgressbar()
        etUsername!!.error = "Username can't be empty!"
    }

    override fun setPasswordError() {
        hideProgressbar()
        etPassword!!.error = "password can't be empty!"
    }

    override fun onLoginSuccess(username: String?) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("username", username)
        startActivity(intent)
    }

    override fun onLoginError() {
        hideProgressbar()
        Toast.makeText(this, "username or password doesn't match", Toast.LENGTH_LONG).show()
    }

    override fun showProgressbar() {
        progressbar!!.visibility = View.VISIBLE
    }

    override fun hideProgressbar() {
        progressbar!!.visibility = View.GONE
    }
}