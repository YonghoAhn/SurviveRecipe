package moe.misakachan.surviverecipe.util

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import moe.misakachan.surviverecipe.R
import moe.misakachan.surviverecipe.databinding.ItemCardviewBinding
import moe.misakachan.surviverecipe.viewmodel.ItemCardViewModel

class RecipeListRecyclerAdapter: RecyclerView.Adapter<BindingViewHolder<ItemCardviewBinding>>() {
    private val listItemViewModels: ArrayList<ItemCardViewModel> = ArrayList()

    inner class ListItemDifferentCallback(
        private val oldListItemViewModels: ArrayList<ItemCardViewModel>,
        private val newListItemViewModels: ArrayList<ItemCardViewModel>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int {
            return oldListItemViewModels.size
        }

        override fun getNewListSize(): Int {
            return newListItemViewModels.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem: ItemCardViewModel = oldListItemViewModels[oldItemPosition]
            val newItem: ItemCardViewModel = newListItemViewModels[newItemPosition]
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            val oldItem: ItemCardViewModel = oldListItemViewModels[oldItemPosition]
            val newItem: ItemCardViewModel = newListItemViewModels[newItemPosition]

            return true
        }
    }

    fun updateItems(listItemViewModels: ArrayList<ItemCardViewModel>) {
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
    ): BindingViewHolder<ItemCardviewBinding> {
        val inflater = LayoutInflater.from(parent.context)
        return BindingViewHolder<ItemCardviewBinding>(
            inflater.inflate(
                R.layout.item_cardview,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(
        holder: BindingViewHolder<ItemCardviewBinding>,
        position: Int
    ) {
        holder.binding().vm = listItemViewModels[position]
    }

    override fun getItemCount(): Int {
        return listItemViewModels.size
    }
}