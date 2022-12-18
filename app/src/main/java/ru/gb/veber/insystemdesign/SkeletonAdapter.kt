package ru.gb.veber.insystemdesign

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.view.ContextThemeWrapper
import androidx.recyclerview.widget.RecyclerView
import ru.gb.veber.insystemdesign.databinding.EmptyViewBinding
import ru.gb.veber.insystemdesign.databinding.SkeletoneHeaderBinding

typealias OnUserClickListener = (login: SkeletonModel) -> Unit


class SkeletonAdapter(private val onUserClickListener: OnUserClickListener) :
    RecyclerView.Adapter<BaseViewHolder>() {

    var skeletonList: List<SkeletonModel> = emptyList()

    fun setList(list: List<SkeletonModel>) {
        skeletonList = list
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return skeletonList[position].viewType
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when (viewType) {
            0 -> SkeletonViewHolder(EmptyViewBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false), onUserClickListener)
            1 -> SkeletonHeaderViewHolder(SkeletoneHeaderBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false))
            else -> {
                SkeletonViewHolder(EmptyViewBinding.inflate(LayoutInflater.from(parent.context),
                    parent,
                    false), onUserClickListener)
            }
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(skeletonList[position])
    }

    override fun getItemCount() = skeletonList.size
}

class SkeletonViewHolder(
    private val binding: EmptyViewBinding,
    private val onUserClickListener: OnUserClickListener,
) : BaseViewHolder(binding.root) {

    override fun bind(item: SkeletonModel) = with(binding) {
        item.name = item.skeletonShape.name
        binding.root.setBackgroundResource(item.getColor())

        var marginSkeleton = 0
        marginSkeleton = when (item.skeletonShape) {
            SkeletonShape.SkeletonCirclePrimary -> item.margin.getDp(itemView.context).toInt()
            SkeletonShape.SkeletonCircleSecondary -> item.margin.getDp(itemView.context).toInt()
            SkeletonShape.SkeletonCircleGames -> item.margin.getDp(itemView.context).toInt()
            else -> {
                0
            }
        }


        root.addView(
            View(ContextThemeWrapper(itemView.context, item.getStyle()),
                null,
                0).apply {
                layoutParams =
                    LinearLayout.LayoutParams(item.wightDp.getDp(itemView.context).toInt(),
                        item.heightDp.getDp(itemView.context).toInt())
                (layoutParams as LinearLayout.LayoutParams).setMargins(
                    item.margin.getDp(itemView.context).toInt(),item.margin.getDp(itemView.context).toInt(),0,item.margin.getDp(itemView.context).toInt())
                setOnLongClickListener {
                    onUserClickListener.invoke(item)
                    true
                }
            }
        )
    }
}

class SkeletonHeaderViewHolder(
    private val binding: SkeletoneHeaderBinding,
) : BaseViewHolder(binding.root) {

    override fun bind(item: SkeletonModel) {
        binding.textViewHeader.text = item.name
    }
}

abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(item: SkeletonModel)

    companion object {
        const val VIEW_TYPE_TOP_NEWS = 0
        const val VIEW_TYPE_TOP_NEWS_HEADER = 1
        const val VIEW_TYPE_SEARCH_NEWS = 2
        const val VIEW_TYPE_FAVORITES_NEWS = 3
        const val VIEW_TYPE_HISTORY_NEWS = 4
        const val VIEW_TYPE_HISTORY_HEADER = 5
    }
}


