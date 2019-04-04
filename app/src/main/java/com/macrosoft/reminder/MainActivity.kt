package com.macrosoft.reminder

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.macrosoft.reminder.model.User
import kotlinx.android.synthetic.main.login_fragment.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_fragment)

        var blockedCountdown = 0
        var fails = 0     //Thought of adding a 5 min disabled time if there are 5 failed login attempts
        var blocked = false

        val LoginButton = findViewById(R.id.loginButton) as Button

        //val SignupButton = findViewById(R.id.SignUpButton) as Button
        //^^ this is for when we implement a signup button

        LoginButton.setOnClickListener {

            val databaseUser = "GET USERNAME FROM DB" //Your up Mr.Kia  We need the these varibles from the DB
            val databasePass = "GET PASSWORD FROM DB"


            var enteredUser = findViewById(R.id.textuser) as EditText //get the data from the user and pass text boxes
            var enteredPass = findViewById(R.id.textpass) as EditText




            //the following if-else checks if the login is sucesfull

            if(enteredPass.text.toString()==databasePass && enteredUser.text.toString()==databaseUser && blocked==false){

//                this will be executed if the login is sucesfull. we dont have a activity yet so put it in here

//                val loggedInPage = Intent(this,ENTER LOGGED IN ACTIVITY HERE)
//                startActivity(loggedInPage)

                Toast.makeText(this@MainActivity, "Login Sucessful", Toast.LENGTH_LONG).show()
            }

            else{

                //clear the fields
                enteredPass.setText("")
                enteredUser.setText("")

                //user failed to login
                //checks if user failed to login 5 times


                //checks if user failed to login 5 times and starts a 5 minuite timer if they did
                if(fails == 4 && blocked == false){

                    val idiot = object : CountDownTimer(302000, 1000) {
                        override fun onTick(millisUntilFinished: Long) {
                            blocked = true
                            blockedCountdown = (millisUntilFinished/1000/60).toInt()
                        }
                        override fun onFinish() {
                            blocked=false
                            fails = 0
                            Toast.makeText(this@MainActivity, "Try to login again now", Toast.LENGTH_LONG).show()
                        }
                    }.start()
                }

                else if(blocked==true){
                    Toast.makeText(this@MainActivity, "Try again in "+blockedCountdown+" minuits.", Toast.LENGTH_LONG).show()

                }
                else{
                    fails += 1
                    Toast.makeText(this@MainActivity, "Login Failed. Try again ", Toast.LENGTH_LONG).show()
                }

                }
            }

        }

    }
