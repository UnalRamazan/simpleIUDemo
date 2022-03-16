package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_welcome_menu.*

class MainWelcomeMenu : AppCompatActivity() {

    lateinit var preferences: SharedPreferences//xml ye erişmek için

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome_menu)

        //xml den veri çekme
        preferences = getSharedPreferences("Information", MODE_PRIVATE)
        var registeredUser = preferences.getString("User's Name", "")
        var registeredMail = preferences.getString("User's Mail", "")
        var registeredPassWord = preferences.getString("User's Password", "")

        //textViewlere kayıtlı bilgileri aktarıyoruz
        welcomeUserInfo.text = "User's Name: " + registeredUser.toString()
        welcomeMailInfo.text = "Mail: " + registeredMail.toString()
        welcomePassword.text = "Password: " + registeredPassWord.toString()

        welcomeBtnSingOut.setOnClickListener {//sign out butonu
            intent = Intent(applicationContext, MainActivity::class.java)//sayfa arasında geçiş yapabilmek için
            startActivity(intent)
            finish()
        }
    }
}