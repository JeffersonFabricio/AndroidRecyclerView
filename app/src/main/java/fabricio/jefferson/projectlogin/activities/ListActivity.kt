package fabricio.jefferson.projectlogin.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import fabricio.jefferson.projectlogin.adapters.MyAdapter
import fabricio.jefferson.projectlogin.model.Note
import fabricio.jefferson.projectlogin.R
import kotlinx.android.synthetic.main.activity_list.*

class ListActivity : AppCompatActivity() {

    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        txtNameParameter.text = intent?.getStringExtra("login")
        recycleView.layoutManager = LinearLayoutManager(this)

        adapter =
            MyAdapter(mutableListOf())
        recycleView.adapter = adapter

        val listNotes = ArrayList<Note>()
        listNotes.add(Note("Jeffers",""))
        listNotes.add(Note("Haldny",""))
        listNotes.add(Note("Fulano",""))
        listNotes.add(Note("Ciclano",""))

        /*floatingActionBtn.setOnClickListener{
            var cont: Int
            cont = 0
            adapter.addNote(listNotes[cont])
            cont =+ 1
        }*/

    }
}
