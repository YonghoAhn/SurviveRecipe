package moe.misakachan.surviverecipe.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import moe.misakachan.surviverecipe.R
import moe.misakachan.surviverecipe.viewmodel.RecipeInfoViewModel
import moe.misakachan.surviverecipe.viewmodel.RecipeProgressViewModel

class RecipeInfoFragment : Fragment() {

    companion object {
        fun newInstance() =
            RecipeInfoFragment()
    }

    private lateinit var viewModel: RecipeInfoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipe_info, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RecipeInfoViewModel::class.java)
    }
}