package uz.pdp.contactapp

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import uz.pdp.contactapp.adapter.CustomAdapter
import uz.pdp.contactapp.dp.MyDatabaseHelper

class ContactFragment : Fragment() {
    lateinit var root:View
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: CustomAdapter
    lateinit var myDatabaseHelper: MyDatabaseHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        getActivity()?.setTitle("Barcha kontaktlar");
        root =  inflater.inflate(R.layout.fragment_contact, container, false)
        recyclerView = root.findViewById(R.id.recyclerView)
        adapter = CustomAdapter(myDatabaseHelper.getAllContacts())
        recyclerView.layoutManager = GridLayoutManager(context,1)

        recyclerView.adapter = adapter

        return root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        myDatabaseHelper = MyDatabaseHelper(context)

    }
}