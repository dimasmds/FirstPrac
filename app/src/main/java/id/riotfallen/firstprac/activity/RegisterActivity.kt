package id.riotfallen.firstprac.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import id.riotfallen.firstprac.R
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.alert
import org.jetbrains.anko.toast
import org.jetbrains.anko.yesButton

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        buttonSubmit.setOnClickListener { _ ->
            if((editTextRegisterPassword.text.toString() == editTextRegisterRePassword.text.toString()) && !editTextRegisterPassword.text.isNullOrBlank()){
                alert("Name: ${editTextRegisterFullName.text}\n" +
                        "Email: ${editTextRegisterEmail.text}\n" +
                        "Ages: ${editTextRegisterAges.text}\n" +
                        "Password: ${editTextRegisterPassword.text}\n" +
                        "Re-Password: ${editTextRegisterRePassword.text}") {
                    yesButton { onBackPressed() }
                }.show()
            } else {
                toast("your password not match")
            }
        }
    }
}
