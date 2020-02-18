package moe.misakachan.surviverecipe.activity

import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableArrayList
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_item_list_dialog_list_dialog.*
import kotlinx.android.synthetic.main.terms_fragment.*
import moe.misakachan.surviverecipe.R
import moe.misakachan.surviverecipe.databinding.ActivityMainPageBinding
import moe.misakachan.surviverecipe.fragment.ItemListDialogFragment
import moe.misakachan.surviverecipe.fragment.SearchResultFragment
import moe.misakachan.surviverecipe.fragment.TermsFragment
import moe.misakachan.surviverecipe.util.MainRecyclerAdpater
import moe.misakachan.surviverecipe.util.RecipeListRecyclerAdapter
import moe.misakachan.surviverecipe.viewmodel.ItemCardViewModel
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
    listItemViewModels: ObservableArrayList<ItemCardViewModel>
) {
    val adapter: RecipeListRecyclerAdapter
    if (recyclerView.adapter == null) {
        adapter = RecipeListRecyclerAdapter()
        recyclerView.adapter = adapter
    } else {
        adapter = recyclerView.adapter as RecipeListRecyclerAdapter
    }
    adapter.updateItems(listItemViewModels)
}

class MainPageActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_page)
        binding.viewModel = MainViewModel()


        var fab = findViewById<FloatingActionButton>(R.id.fab_main_addrecipe)
        var bottomappbar = findViewById<BottomAppBar>(R.id.bottomappbar_mainActi)
        var search = findViewById<EditText>(R.id.searchEditText_main)
        //var bottomSheetBehavior = BottomSheetBehavior.from(navigation_view)
        setSupportActionBar(bottomappbar)

        bottomappbar.setNavigationOnClickListener {
            val bottomNavDrawerFragment = ItemListDialogFragment()
            bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
        }
        /*
        search.onFocusChangeListener = object : View.OnFocusChangeListener{
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                if (hasFocus){
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.mainRecycler,SearchResultFragment())
                        .commit()
                }
                //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
        */
        
        search.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH){
                val resultFragment = SearchResultFragment()
                resultFragment.show(supportFragmentManager, resultFragment.tag)
                true

            }
            else {
                false
            }
        }

        //val navController = findNavController(R.id.bottomappbar_mainActi)
        //val icon = DrawerArrowDrawable(bottomappbar.context)
        //bottomappbar.navigationIcon = icon

        //bottomappbar.setupWithNavController(navController)


        fab.setOnClickListener{
            //TODO addRecipe
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.navigation, menu)
        return true
    }
    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.bottomappbar_mainActi).navigateUp()
    }



}
