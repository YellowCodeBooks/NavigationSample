package com.yellowcode.navigationsample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

class ProfileFragment : Fragment() {

    private val userViewModel: UserViewModel by activityViewModels()
    val args: ProfileFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = args.nameArg
        view.findViewById<TextView>(R.id.tvWelcome)?.text = getString(R.string.welcome, "$name")

        view.findViewById<Button>(R.id.btnLogout).setOnClickListener {
            userViewModel.logout().observe(viewLifecycleOwner, {
                findNavController().popBackStack()
            })
        }
    }
}