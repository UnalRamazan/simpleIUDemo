package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var preferences: SharedPreferences//verilere eişmek için

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)//ilk çalıştığı zaman hangi tasarım dosyasının çalıştıracağını söylüyor

        preferences = getSharedPreferences("Information", MODE_PRIVATE)//dosya adı

        bSingIn.setOnClickListener {//sign in butonu

            var registeredUser = preferences.getString("User's Name", "")
            var registeredMail = preferences.getString("User's Mail", "")
            var registeredPassword = preferences.getString("User's Password", "")

            var loginUser = personName.text.toString()
            var loginMail = emailAddress.text.toString()
            var loginPassword = password.text.toString()

            if ((registeredUser == loginUser) && (registeredPassword == loginPassword) && (registeredMail == loginMail)) {
                intent = Intent(applicationContext, MainWelcomeMenu::class.java)//sayfa arasında geçiş yapabilmek için
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "Login information is wrong", Toast.LENGTH_LONG).show()//ekrana uyarı yazdurmak için
            }

            personName.text.clear()
            emailAddress.text.clear()
            password.text.clear()
        }

        bSingUp.setOnClickListener {//sing up butonu
            textView.text = "Long live we will have a new friend."
            intent = Intent(applicationContext, MainRegisterMenu::class.java)//sayfa arasında geçiş yapabilmek için
            startActivity(intent)

            textView.text = "Let's Code World Of Tomorrow"
        }

        bForgetPassword.setOnClickListener {//forget password butonu
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.doftdare.com/"))
            startActivity(i)
        }
    }
}