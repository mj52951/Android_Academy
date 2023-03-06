package com.example.android_academy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class SecondFragment : Fragment() {

    private val viewModel : ListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvContactsList: TextView = view.findViewById(R.id.tv_contacts_list)

        viewModel.contacts.observe(viewLifecycleOwner) {
            val re = Regex("[^A-Za-z0-9 \n]")
            val listString = re.replace(it.toString(), "")

            tvContactsList.text = listString
        }
    }


}