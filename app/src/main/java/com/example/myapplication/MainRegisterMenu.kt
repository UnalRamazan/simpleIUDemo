package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main_kayit_ol.*

class MainRegisterMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_kayit_ol)

        registerBtnSingUp1.setOnClickListener {

            var userInfo = registerPersonName.text.toString()
            var mailInfo = registerEmailAddress1.text.toString()
            var passwordInfo = registerPassword1.text.toString()

            var boolean : Boolean = false


            //mail kontrol
            for(letter in mailInfo){
                if(letter == '@'){
                    boolean = true;
                }
            }

            if (userInfo != "" && mailInfo != "" && passwordInfo != "" && boolean) {//veriler eksik değilse

                var SharedPreferences = this.getSharedPreferences("Information", MODE_PRIVATE)//verileri kaydetmek için
                var editor = SharedPreferences.edit()//verileri değiştirebilmek için

                //veri ekleme
                editor.putString("User's Name", "$userInfo").apply()
                editor.putString("User's Mail", "$mailInfo").apply()
                editor.putString("User's Password", "$passwordInfo").apply()

                Toast.makeText(applicationContext, "Registered is successful", Toast.LENGTH_LONG).show()

                intent = Intent(applicationContext, MainWelcomeMenu::class.java)//sayfa arasında geçiş yapabilmek için
                startActivity(intent)
            } else {
                if(!boolean){
                    Toast.makeText(applicationContext, "Your email address is wrong.", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(applicationContext, "Registered is not successful, please try again.", Toast.LENGTH_LONG).show()
                }
            }

            registerPersonName.text.clear()
            registerEmailAddress1.text.clear()
            registerPassword1.text.clear()
        }
    }
}