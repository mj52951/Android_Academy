package com.example.android_academy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels

class SecondFragment : Fragment() {

    private val viewModel: ListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val linearLayout: LinearLayout = view.findViewById(R.id.linearLayout01)

        viewModel.contacts.observe(viewLifecycleOwner) { list ->

            list.forEach {
                val tempTextView = TextView(requireContext())
                tempTextView.text = it.toString()
                tempTextView.textSize = 25f
                linearLayout.addView(tempTextView)
            }
        }
    }
}