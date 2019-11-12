package fabricio.jefferson.projectlogin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val notes: MutableList<Note>): RecyclerView.Adapter<MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_recycle_view, parent,false)
        )
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val note = notes[position]
        holder.title.text = note.title
        holder.delete.setOnClickListener {
            notes.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, notes.size)
        }
        holder.edit.setOnClickListener{
            holder.title.text = note.title
            notifyItemChanged(position)
        }
    }

    fun addNote(note:Note){
        notes.add(note)
        notifyItemInserted(itemCount)
    }

}