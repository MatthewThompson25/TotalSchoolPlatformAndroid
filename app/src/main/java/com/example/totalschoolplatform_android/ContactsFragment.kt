package com.example.totalschoolplatform_android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ContactsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ContactsFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ContactsAdapter
    private val contactList = listOf(
        Contact("1", "James Alexander Smith", "R.drawable.person_placeholder"),
        Contact("2", "Emily Rose Johnson", "R.drawable.person_placeholder"),
        Contact("3", "William Thomas Brown", "R.drawable.person_placeholder"),
        Contact("4", "Sophia Elizabeth Davis", "R.drawable.person_placeholder")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_contact, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewContacts)
        adapter = ContactsAdapter(contactList) {
            val chatFragment = HomeFragment() // messages need to be linked here later
            parentFragmentManager.beginTransaction()
                .replace(R.id.frameLayout, chatFragment)
                .addToBackStack(null)
                .commit()
        }
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(): ContactsFragment {
            return ContactsFragment()
        }
    }
}
