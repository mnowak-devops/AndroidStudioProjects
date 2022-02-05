package com.matdev.tam_projekt.Presenter

import android.os.Handler
import android.text.TextUtils

class LoginInteractor {
    interface OnLoginFinishedListener {
        fun onUsernameError()
        fun onPasswordError()
        fun onLoginSuccess(username: String?)
        fun onLoginError()
    }

    fun canLogin(username: String, password: String, listener: OnLoginFinishedListener) {
        Handler().postDelayed(Runnable {
            if (TextUtils.isEmpty(username)) {
                listener.onUsernameError()
                return@Runnable
            }
            if (TextUtils.isEmpty(password)) {
                listener.onPasswordError()
                return@Runnable
            }
            if (username.equals("himanshu", ignoreCase = true) && password.equals(
                    "1234",
                    ignoreCase = true
                )
            ) {
                listener.onLoginSuccess(username)
                return@Runnable
            }
            listener.onLoginError()
        }, 2000)
    }
}