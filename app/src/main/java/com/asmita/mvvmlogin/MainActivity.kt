package com.asmita.mvvmlogin

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import com.asmita.mvvmlogin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    companion object {
        @JvmStatic
        @BindingAdapter("toastMessage")
        fun runMe(view: View, message: String?) {
            if (message != null) Toast
                .makeText(
                    view.context, message,
                    Toast.LENGTH_SHORT
                )
                .show()
        }
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )
        binding.viewModel = AppViewModel()
        binding.executePendingBindings()
    }



}