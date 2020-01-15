package moe.misakachan.surviverecipe.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moe.misakachan.surviverecipe.R
import moe.misakachan.surviverecipe.viewmodel.SearchResultViewModel

class SearchResultFragment : Fragment() {

    companion object {
        fun newInstance() =
            SearchResultFragment()
    }

    private lateinit var viewModel: SearchResultViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_result_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SearchResultViewModel::class.java)
        // TODO: Use the ViewModel
    }

}