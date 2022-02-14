package uz.pdp.contactapp

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import uz.pdp.contactapp.dp.MyDatabaseHelper
import uz.pdp.contactapp.model.Contact


class ChangeFragment : Fragment() {
    lateinit var root:View
    lateinit var myDatabaseHelper: MyDatabaseHelper
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getActivity()?.setTitle("Kontakt qo'shish");
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_change, container, false)

        val et_name = root.findViewById<EditText>(R.id.et_name)
        val et_number = root.findViewById<EditText>(R.id.et_number)
        val add2_btn = root.findViewById<Button>(R.id.add2_btn)

        add2_btn.setOnClickListener {
            if (et_name.length()>0 && et_number.length()>0){
                val name = et_name.text.toString()
                val number = et_number.text.toString()
                val contact = Contact(name, number)
                myDatabaseHelper.addContact(contact)
                Toast.makeText(context, "Muvafaqqiyatli qo'shildi", Toast.LENGTH_SHORT).show()
                getActivity()?.onBackPressed();
            } else {
                Toast.makeText(context, "To'liq to'ldiring", Toast.LENGTH_SHORT).show()
            }
        }



        return root
    }

    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        myDatabaseHelper = MyDatabaseHelper(activity)
    }
}