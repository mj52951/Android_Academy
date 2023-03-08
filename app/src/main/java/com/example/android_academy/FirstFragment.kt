package com.example.android_academy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class FirstFragment : Fragment() {

    private val viewModel: ListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnAdd: Button = view.findViewById(R.id.btn_add)

        btnAdd.setOnClickListener {
            val contactFName: EditText = view.findViewById(R.id.et_first_name)
            val contactLName: EditText = view.findViewById(R.id.et_last_name)
            val contactAge: EditText = view.findViewById(R.id.et_age)
            val contactOib: EditText = view.findViewById(R.id.et_oib)

            val contact = Contact(contactFName.text.toString(), contactLName.text.toString(),
                contactAge.text.toString().toInt(), contactOib.text.toString().toInt())

            viewModel.addContact(contact)

            contactFName.text.clear()
            contactLName.text.clear()
            contactAge.text.clear()
            contactOib.text.clear()

        }
    }
}