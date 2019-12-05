package fabricio.jefferson.projectlogin

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnCancelLogin.setOnClickListener {
            finish()
        }

        btnConfirmLogin.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            intent.putExtra("login", editTxtLoginLogin.text.toString())
            if (validatePassword())
                startActivity(intent)
        }
    }

    private fun validatePassword(): Boolean{
        val password = editTxtPasswordLogin.text.toString()

        if (password[0].isUpperCase())
            intent.putExtra("password", password)
        else {
            Toast.makeText(this, "Password invalid! start with the first letter uppercase.", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    }

}
