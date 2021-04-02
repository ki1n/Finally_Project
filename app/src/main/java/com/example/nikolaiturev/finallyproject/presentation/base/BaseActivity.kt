package com.example.nikolaiturev.finallyproject.presentation.base

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.nikolaiturev.finallyproject.R

abstract class BaseActivity : AppCompatActivity() {
    protected abstract var layoutId: Int

    protected abstract fun iniView()

    private lateinit var progressDialog: Dialog

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme)
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        progressDialog()
        iniView()
    }

    fun showProgressDialog() {
        progressDialog.show()
    }

    fun hideProgressDialog() {
        progressDialog.dismiss()
    }

    private fun progressDialog() {
        progressDialog = Dialog(this)
        // TODO почему переменная названа inflate? что  возвращает метод inflate у LayoutInflater?
        val inflate = LayoutInflater.from(this).inflate(R.layout.layout_progress, null)
        // TODO setContentView в качетве параметра принимает Layout ID, почему мы не можем его туда передать?
        progressDialog.setContentView(inflate)
        progressDialog.setCancelable(false)
        progressDialog.window?.setBackgroundDrawable(
            ColorDrawable(Color.TRANSPARENT)
        )
    }
}
