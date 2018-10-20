package id.riotfallen.firstprac

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val defaultEmail = "dimas.maulanads@gmail.com"
        val defaultPasswword = "qwerty123"

        buttonLogin.setOnClickListener {
            val isEmailValid: Boolean = defaultEmail == editTextEmail.text.toString()
            val isPasswordValid: Boolean = defaultPasswword == editTextPassword.text.toString()
            val isAuthValid = isEmailValid && isPasswordValid


            val massage: String = if(isAuthValid) "Success" else "false"
            Toast.makeText(this@LoginActivity, "Login $massage", Toast.LENGTH_SHORT).show()
        }

        buttonRegisterHere.setOnClickListener {
            startActivity<RegisterActivity>()
        }
    }
}
