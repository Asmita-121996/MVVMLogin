package com.asmita.mvvmlogin

import android.text.TextUtils
import android.util.Patterns
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable


class AppViewModel : BaseObservable() {
    private val model: Model = Model("", "")
    private val successMessage = "Login successful"
    private val errorMessage = "Email or Password is not valid"

    @Bindable
    var toastMessage: String? = null
        private set

    private fun setToastMessage(toastMsg: String) {
        this.toastMessage = toastMsg
        notifyPropertyChanged(BR.toastMessage)
    }

    @get:Bindable
    var userEmail: String?
        get() = model.email
        set(email) {
            model.email = email
            notifyPropertyChanged(BR.userEmail)
        }


    @get:Bindable
    var userPassword: String?
        get() = model.password
        set(password) {
            model.password = password
            notifyPropertyChanged(BR.userPassword)
        }

    // actions to be performed
    // when user clicks
    // the LOGIN button
    fun onButtonClicked() {
        if (isValid) setToastMessage(successMessage) else setToastMessage(errorMessage)
    }

    // method to keep a check
    // that variable fields must
    // not be kept empty by user
    private val isValid: Boolean
        get() = !TextUtils.isEmpty(userEmail) && Patterns.EMAIL_ADDRESS.matcher(userEmail).matches() && userPassword!!.length > 5
}

