package moe.misakachan.surviverecipe.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main_page.*
import kotlinx.android.synthetic.main.custom_listview.*
import moe.misakachan.surviverecipe.R
import moe.misakachan.surviverecipe.databinding.ActivityMainPageBinding
import moe.misakachan.surviverecipe.util.MainRecyclerAdpater
import moe.misakachan.surviverecipe.viewmodel.MainViewModel
import moe.misakachan.surviverecipe.viewmodel.RecipeListViewModel

@BindingAdapter("items")
fun setItems(
    recyclerView: RecyclerView,
    listItemViewModels: ObservableArrayList<RecipeListViewModel>
) {
    val adapter: MainRecyclerAdpater
    if (recyclerView.adapter == null) {
        adapter = MainRecyclerAdpater()
        recyclerView.adapter = adapter
    } else {
        adapter = recyclerView.adapter as MainRecyclerAdpater
    }
    adapter.updateItems(listItemViewModels)
}

@BindingAdapter("liveItems")
fun setLiveItems(
    recyclerView: RecyclerView,
    listItemViewModels: LiveData<ArrayList<RecipeListViewModel>>
) {
    val adapter: MainRecyclerAdpater
    if (recyclerView.adapter == null) {
        adapter = MainRecyclerAdpater()
        recyclerView.adapter = adapter
    } else {
        adapter = recyclerView.adapter as MainRecyclerAdpater
    }
    adapter.updateItems(listItemViewModels.value!!)
}

class MainPageActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_page)
        binding.viewModel = MainViewModel()
        mainSwipeLayout.setOnRefreshListener {
            var viewModel = binding.viewModel as MainViewModel
            viewModel.refreshItems()
            mainRecycler.adapter?.notifyDataSetChanged()
            mainSwipeLayout.isRefreshing=false
        }
    }


}
