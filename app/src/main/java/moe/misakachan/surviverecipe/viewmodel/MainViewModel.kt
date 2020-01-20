package moe.misakachan.surviverecipe.viewmodel

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import moe.misakachan.surviverecipe.model.RecipeList
import moe.misakachan.surviverecipe.repository.RecipeListRepository

class MainViewModel : ViewModel() {
    val recipeArray : ArrayList<RecipeList> = arrayListOf()
    private val repository = RecipeListRepository()
    private var itemCount = 0;
    val mainListViewItems : ObservableArrayList<RecipeListViewModel> = getListItemViewHolders()

    fun getLiveDataListItemViewHolders() : LiveData<ArrayList<RecipeListViewModel>>
    {
        return repository.getLiveDataList("dinner")
    }

    private fun getListItemViewHolders() : ObservableArrayList<RecipeListViewModel>{
        val list = ObservableArrayList<RecipeListViewModel>()
        repository.getRecipeListbyTheme("dinner").addSnapshotListener{ documents, e ->
            if(e!=null)
                Log.wtf("MisakaMOE",e)
            if (documents != null) {
                mainListViewItems.clear()
                for(document in documents) {
                    val item = document.toObject(RecipeList::class.java)
                    val viewModel = RecipeListViewModel()
                    viewModel.setItem(item)
                    list.add(viewModel)
                }
            }
        }
        return list
    }

    fun refreshItems()
    {
        mainListViewItems.clear()
        val items = getListItemViewHolders()
        mainListViewItems.addAll(items)
    }

    fun addListItem()
    {
        ++itemCount
        mainListViewItems.add(RecipeListViewModel())
    }
}