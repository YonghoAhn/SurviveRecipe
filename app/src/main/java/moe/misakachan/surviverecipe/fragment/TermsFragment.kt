package moe.misakachan.surviverecipe.fragment

import android.app.Dialog
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import moe.misakachan.surviverecipe.R
import moe.misakachan.surviverecipe.viewmodel.TermsViewModel

class TermsFragment : DialogFragment() {

    companion object {
        fun newInstance() = TermsFragment()
    }

    private lateinit var viewModel: TermsViewModel
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(TermsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}