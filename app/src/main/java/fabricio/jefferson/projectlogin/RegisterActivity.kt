package fabricio.jefferson.projectlogin

import android.content.Intent
import android.os.Bundle
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
            intent.putExtra("name", editTxtNameRegister.text.toString())
            intent.putExtra("cpf", editTxtCpfRegister.text.toString())
            intent.putExtra("login", editTxtLoginRegister.text.toString())
            if (validatePassword())
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

}
