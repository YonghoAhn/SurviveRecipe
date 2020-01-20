package moe.misakachan.surviverecipe.viewmodel

import androidx.lifecycle.ViewModel
import moe.misakachan.surviverecipe.model.RecipeList

class RecipeListViewModel : ViewModel() {
    private lateinit var item : RecipeList
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