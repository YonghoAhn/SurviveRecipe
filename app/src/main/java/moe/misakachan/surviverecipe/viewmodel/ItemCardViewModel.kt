package moe.misakachan.surviverecipe.viewmodel

import androidx.lifecycle.ViewModel
import moe.misakachan.surviverecipe.model.Recipe

class ItemCardViewModel: ViewModel() {
    private lateinit var item: Recipe
    fun getItem(): Recipe {
        return item
    }

    fun setItem(item: Recipe)
    {
        this.item = item
    }
}