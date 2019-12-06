package fabricio.jefferson.projectlogin.adapters

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fabricio.jefferson.projectlogin.R

class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var title: TextView = itemView.findViewById(R.id.editTxtLayoutRecycleView)
    var edit: ImageButton = itemView.findViewById(R.id.imgBtnLayoutRecycleViewEdit)
    var delete: ImageButton = itemView.findViewById(R.id.imgBtnLayoutRecycleViewDelete)

}