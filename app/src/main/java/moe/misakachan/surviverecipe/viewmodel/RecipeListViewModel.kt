package moe.misakachan.surviverecipe.viewmodel

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.ViewModel
import moe.misakachan.surviverecipe.model.Recipe
import moe.misakachan.surviverecipe.model.RecipeList
import moe.misakachan.surviverecipe.repository.ItemCardRepository
import moe.misakachan.surviverecipe.repository.RecipeListRepository

class RecipeListViewModel : ViewModel() {
    private val repository = ItemCardRepository()

    private lateinit var item : RecipeList
    val recipeListViewItems : ObservableArrayList<ItemCardViewModel> = getListItemViewHolders()

    private fun getListItemViewHolders() : ObservableArrayList<ItemCardViewModel>{
        val list = ObservableArrayList<ItemCardViewModel>()
        repository.getRecipeListbyTheme("dinner").addSnapshotListener{ documents, e ->
            if(e!=null)
                Log.wtf("MisakaMOE",e)
            if (documents != null) {
                    recipeListViewItems.clear()
                    for(document in documents) {
                    val item = document.toObject(Recipe::class.java)
                    val viewModel = ItemCardViewModel()
                    viewModel.setItem(item)
                    list.add(viewModel)
                }
            }
        }
        return list
    }

    fun setItem(item:RecipeList)
    {
        this.item = item
    }
    fun getItem(): RecipeList {
        return this.item
    }
    fun getTheme() : String{
        return item.theme
    }
    fun getName():String{
        return item.name
    }
}