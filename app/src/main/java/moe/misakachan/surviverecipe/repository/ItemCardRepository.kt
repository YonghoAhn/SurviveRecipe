package moe.misakachan.surviverecipe.repository

import androidx.databinding.ObservableArrayList
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import moe.misakachan.surviverecipe.viewmodel.RecipeListViewModel

class ItemCardRepository {
    private var firestore = FirebaseFirestore.getInstance()
    var user = FirebaseAuth.getInstance().currentUser

    fun getRecipeListbyTheme(theme:String): Query {
        return firestore.collection("recipe").whereArrayContains("theme",theme)
    }
}