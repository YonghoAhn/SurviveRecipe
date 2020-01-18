package moe.misakachan.surviverecipe.viewmodel

import androidx.lifecycle.ViewModel
import moe.misakachan.surviverecipe.model.RecipeList

class MainViewModel : ViewModel() {
    val recipeArray : ArrayList<RecipeList> = arrayListOf()

}