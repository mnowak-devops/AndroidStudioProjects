package com.matdev.tam_projekt.View

interface LoginView {
    fun setUsernameError()
    fun setPasswordError()
    fun showProgressbar()
    fun hideProgressbar()
    fun onLoginSuccess(username: String?)
    fun onLoginError()
}