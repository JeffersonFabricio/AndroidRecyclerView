package fabricio.jefferson.projectlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    private lateinit var adapter:MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        txtNameParameter.text = intent?.getStringExtra("login")
        recycleView.layoutManager = LinearLayoutManager(this)

        adapter = MyAdapter(mutableListOf())
        recycleView.adapter = adapter

        floatingActionBtn.setOnClickListener{
            val note = Note("Jeffers")
            adapter.addNote(note)
        }

    }
}
