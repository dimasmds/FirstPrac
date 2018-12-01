package id.riotfallen.firstprac

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import id.riotfallen.core.Utils
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val defaultEmail = ""
        val defaultPasswword = ""

        buttonLogin.setOnClickListener {
            val isEmailValid: Boolean = defaultEmail == editTextEmail.text.toString()
            val isPasswordValid: Boolean = defaultPasswword == editTextPassword.text.toString()
            val isAuthValid = isEmailValid && isPasswordValid

            if(isAuthValid){
                startActivity<MainActivity>()
            } else {
                toast("Login Failed")
            }
        }

        buttonRegisterHere.setOnClickListener {
            startActivity<RegisterActivity>()
        }
    }

}
