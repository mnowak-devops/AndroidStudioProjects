package com.matdev.tam_projekt.Presenter

import com.matdev.tam_projekt.View.LoginView

class LoginPresenter(loginView: LoginView?, loginInteractor: LoginInteractor) :
    LoginInteractor.OnLoginFinishedListener {
    private val loginView: LoginView? = loginView
    private val loginInteractor: LoginInteractor = loginInteractor
    override fun onLoginError() {
        loginView?.onLoginError()
    }

    fun validateCredentials(username: String?, password: String?) {
        if (loginView != null) {
            loginInteractor.canLogin(username, password, this)
        }
    }

    override fun onUsernameError() {
        loginView?.setUsernameError()
    }

    override fun onPasswordError() {
        loginView?.setPasswordError()
    }

    override fun onLoginSuccess(username: String?) {
        loginView?.onLoginSuccess(username)
    }

}