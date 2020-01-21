package moe.misakachan.surviverecipe.viewmodel

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import moe.misakachan.surviverecipe.R
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

    fun getUrl():String{
        return item.thumbnail_url
    }

    fun getRecipeName() : String {
        return item.recipe_name
    }

    fun getUserName() : String{
        return "by ${item.author_name}"
    }
}

@BindingAdapter("squareRecipeImage")
fun setSquareRecipeImage(view:ImageView, imgUrl:String){
    Glide.with(view.context).load(imgUrl).apply(RequestOptions().placeholder(R.drawable.mapatofu)).into(view)
}