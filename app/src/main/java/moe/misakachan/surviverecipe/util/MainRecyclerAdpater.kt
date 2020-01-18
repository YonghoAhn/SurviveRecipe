package moe.misakachan.surviverecipe.util

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import moe.misakachan.surviverecipe.model.RecipeList

class MainRecyclerAdpater(val context: Context, val List, ArrayList<RecipeList>) :
    RecyclerView.Adapter<RecipeList>() {
    inner class Holder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeList {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

}