package uz.pdp.contactapp

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class HomeFragment : Fragment() {
    lateinit var root: View
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_home, container, false)

        getActivity()?.setTitle("Asosiy oyna");

        val contacts_btn = root.findViewById<Button>(R.id.contactList_btn)
        val add_btn = root.findViewById<Button>(R.id.add_btn)

        contacts_btn.setOnClickListener {
            view?.findNavController()?.navigate(R.id.contactFragment)
        }

        add_btn.setOnClickListener {
            view?.findNavController()?.navigate(R.id.changeFragment)
        }

        return root
    }

}