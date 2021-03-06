package moe.misakachan.surviverecipe.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moe.misakachan.surviverecipe.R
import moe.misakachan.surviverecipe.viewmodel.RecipeProgressViewModel

class RecipeProgressFragment : Fragment() {

    companion object {
        fun newInstance() =
            RecipeProgressFragment()
    }

    private lateinit var viewModel: RecipeProgressViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recipe_progress_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RecipeProgressViewModel::class.java)
    }
}