package moe.misakachan.surviverecipe.repository

import android.util.Log
import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import moe.misakachan.surviverecipe.model.RecipeList
import moe.misakachan.surviverecipe.viewmodel.RecipeListViewModel

class RecipeListRepository {
    var firestore = FirebaseFirestore.getInstance()
    var user = FirebaseAuth.getInstance().currentUser
    var mainListViewItems: ObservableArrayList<RecipeListViewModel> = ObservableArrayList()

    fun getLiveDataList(theme:String): LiveData<ArrayList<RecipeListViewModel>>
    {
        return MutableLiveData<ArrayList<RecipeListViewModel>>(mainListViewItems)
    }

    fun getRecipeListbyTheme(theme:String): Query {
        return firestore.collection("recipe_list").whereEqualTo("theme",theme)
    }
}