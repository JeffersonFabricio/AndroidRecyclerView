package fabricio.jefferson.projectlogin

import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var title: TextView = itemView.findViewById(R.id.editTxtLayoutRecycleView)
    var delete: ImageButton = itemView.findViewById(R.id.imgBtnLayoutRecycleView)

}