package moe.misakachan.surviverecipe.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import moe.misakachan.surviverecipe.R
import moe.misakachan.surviverecipe.databinding.CustomListviewBinding
import moe.misakachan.surviverecipe.viewmodel.RecipeListViewModel


class MainRecyclerAdpater : RecyclerView.Adapter<BindingViewHolder<CustomListviewBinding>>() {
    private val listItemViewModels: ArrayList<RecipeListViewModel> = ArrayList()

    inner class ListItemDifferentCallback(
        private val oldListItemViewModels: ArrayList<RecipeListViewModel>,
        private val newListItemViewModels: ArrayList<RecipeListViewModel>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldListItemViewModels.size
        }

        override fun getNewListSize(): Int {
            return newListItemViewModels.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem: RecipeListViewModel = oldListItemViewModels[oldItemPosition]
            val newItem: RecipeListViewModel = newListItemViewModels[newItemPosition]
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem: RecipeListViewModel = oldListItemViewModels[oldItemPosition]
            val newItem: RecipeListViewModel = newListItemViewModels[newItemPosition]
            if(oldItem.getItem().recipe_id != newItem.getItem().recipe_id) return false
            if(oldItem.getItem().name != newItem.getItem().name) return false
            if(oldItem.getItem().theme != newItem.getItem().theme) return false
            return true
        }
    }

    fun updateItems(listItemViewModels: ArrayList<RecipeListViewModel>) {
        val callback = ListItemDifferentCallback(this.listItemViewModels, listItemViewModels)
        val result = DiffUtil.calculateDiff(callback)
        this.listItemViewModels.clear()
        this.listItemViewModels.addAll(listItemViewModels)
        result.dispatchUpdatesTo(this)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BindingViewHolder<CustomListviewBinding> {
        val inflater = LayoutInflater.from(parent.context)
        return BindingViewHolder<CustomListviewBinding>(
            inflater.inflate(
                R.layout.custom_listview,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: BindingViewHolder<CustomListviewBinding>,
        position: Int
    ) {
        holder.binding().vm = listItemViewModels[position]
    }

    override fun getItemCount(): Int {
        return listItemViewModels.size
    }
}