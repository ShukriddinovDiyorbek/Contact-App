package uz.pdp.contactapp.adapter

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import uz.pdp.contactapp.R
import uz.pdp.contactapp.model.Contact

class CustomAdapter(var items:ArrayList<Contact>) : RecyclerView.Adapter<CustomAdapter.ContactViewHolder>() {
    inner class ContactViewHolder(view: View):RecyclerView.ViewHolder(view){
        val tv_name: TextView
        val tv_number:TextView
        val linear: LinearLayout

        init {
            tv_name = view.findViewById(R.id.tv_name)
            tv_number = view.findViewById(R.id.tv_number)
            linear = view.findViewById(R.id.ll)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rv,parent,false)

        return ContactViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item = items[position]
        holder.tv_name.setText(item.name)
        holder.tv_number.setText(item.number)

    }

    override fun getItemCount(): Int {
        return items.size
    }

}