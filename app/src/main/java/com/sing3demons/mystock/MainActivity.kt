package com.sing3demons.mystock

import android.content.ContextWrapper
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pixplicity.easyprefs.library.Prefs
import com.sing3demons.mystock.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Prefs.Builder()
            .setContext(this)
            .setMode(ContextWrapper.MODE_PRIVATE)
            .setPrefsName(packageName)
            .setUseDefaultSharedPreference(true)
            .build()

        if (Prefs.getBoolean(PREFS_KEY_LOGIN, false)) {
            openHomePage()
        } else {
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)

            setupWidget()
        }


    }

    private fun openHomePage() {
        Intent(applicationContext, HomeActivity::class.java).run {
            startActivity(this)
            finish()
        }
    }

    private fun setupWidget() {
        binding.loginButton.setOnClickListener {
            validate()
        }

        //scop function
        binding.loginScrollview.apply {
            isVerticalScrollBarEnabled = false
            isHorizontalScrollBarEnabled = false
        }

//        binding.loginScrollview.isVerticalScrollBarEnabled = false
//        binding.loginScrollview.isHorizontalScrollBarEnabled = false
    }

    private fun validate() {
        val username = binding.loginEdittextUsername.text.toString()
        val password = binding.loginEdittextPassword.text.toString()


        if (username.isEmpty() || password.isEmpty()) {
            showToast("Username or Password is Empty")
            return
        }

        if (username == "user@gmail.com" && password == "1234") {
            Prefs.putBoolean(PREFS_KEY_LOGIN, true)
            Prefs.putString(PREFS_KEY_USERNAME, username)
            openHomePage()
            return
        }

        showToast("Usernane: $username or Password: $password incorrect")


    }

}