package fabricio.jefferson.projectlogin

import android.content.Intent
import android.os.Bundle
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
            intent.putExtra("password", editTxtPasswordLogin.text.toString())
            startActivity(intent)
        }
    }

}
