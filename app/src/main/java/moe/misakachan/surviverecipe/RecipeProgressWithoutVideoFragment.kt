package moe.misakachan.surviverecipe

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class RecipeProgressWithoutVideoFragment : Fragment() {

    companion object {
        fun newInstance() = RecipeProgressWithoutVideoFragment()
    }

    private lateinit var viewModel: RecipeProgressWithoutVideoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.recipe_progress_without_video_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RecipeProgressWithoutVideoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}