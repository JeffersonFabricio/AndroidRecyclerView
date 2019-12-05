package fabricio.jefferson.projectlogin

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnCancelRegister.setOnClickListener {
            finish()
        }

        btnConfirmRegister.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra("cpf", editTxtCpfRegister.text.toString())
            intent.putExtra("login", editTxtLoginRegister.text.toString())
            if (validatePassword() && validateEmail())
                startActivity(intent)
        }
    }

    private fun validatePassword(): Boolean{
        val password = editTxtPasswordRegister.text.toString()

        if (password[0].isUpperCase())
            intent.putExtra("password", password)
        else {
            Toast.makeText(this, "Password invalid! start with the first letter uppercase.", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }

    private fun validateEmail(): Boolean {

        val email = editTxtEmailRegister.text.toString()
        val pattern = Patterns.EMAIL_ADDRESS
        if (email.matches(pattern.toRegex())){
            intent.putExtra("email", email)
        }
        else {
            Toast.makeText(this, "E-mail invalid!", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }

}
