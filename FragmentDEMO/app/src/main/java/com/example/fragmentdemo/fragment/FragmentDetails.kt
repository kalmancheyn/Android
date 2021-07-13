package com.example.fragmentdemo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.fragmentdemo.MainActivity
import com.example.fragmentdemo.R
import kotlinx.android.synthetic.main.fragment_main.view.*

class FragmentDetails : Fragment() {

    companion object {
        const val TAG = "TAG_FRAGMENT_DETAILS"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_details, container, false)
        return rootView
    }

}