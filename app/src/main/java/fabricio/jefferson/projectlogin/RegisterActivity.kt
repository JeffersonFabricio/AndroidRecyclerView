package fabricio.jefferson.projectlogin

import android.content.Intent
import android.os.Bundle
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
            intent.putExtra("password", editTxtPasswordRegister.text.toString())
            startActivity(intent)
        }
    }

}
