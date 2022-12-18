package ru.gb.veber.insystemdesign

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.view.ContextThemeWrapper
import androidx.recyclerview.widget.RecyclerView
import ru.gb.veber.insystemdesign.databinding.SkeletonItemAllBinding
import ru.gb.veber.insystemdesign.databinding.SkeletonItemBinding
import ru.gb.veber.insystemdesign.databinding.SkeletoneHeaderBinding

typealias OnUserClickListener = (login: SkeletonModel) -> Unit


class SkeletonAdapter(private val onUserClickListener: OnUserClickListener) :
    RecyclerView.Adapter<BaseViewHolder>() {

    var skeletonList: List<SkeletonModelList> = emptyList()

    fun setList(list: List<SkeletonModelList>) {
        skeletonList = list
        notifyDataSetChanged()
    }

//    override fun getItemViewType(position: Int): Int {
//        return skeletonList[position].viewType
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return SkeletonListViewHolder(SkeletonItemAllBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false), onUserClickListener)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(skeletonList[position])
    }

    override fun getItemCount() = skeletonList.size
}


class SkeletonListViewHolder(
    private val binding: SkeletonItemAllBinding,
    private val onUserClickListener: OnUserClickListener,
) : BaseViewHolder(binding.root) {

    override fun bind(item: SkeletonModelList) = with(binding) {

        binding.rootContainerView.setBackgroundResource(item.getColor())


        item.listSkeleton.forEach {skeletonItem->


            var marginSkeleton = when (skeletonItem.skeletonShape) {
                SkeletonShape.SkeletonCirclePrimary -> skeletonItem.margin.getDp(itemView.context).toInt()
                SkeletonShape.SkeletonCircleSecondary -> skeletonItem.margin.getDp(itemView.context).toInt()
                SkeletonShape.SkeletonCircleGames -> skeletonItem.margin.getDp(itemView.context).toInt()
                else -> {
                    0
                }
            }

            Log.d("marginSkeleton", "$marginSkeleton skeletonItem = $skeletonItem")

            val skeletonView = View(ContextThemeWrapper(itemView.context, skeletonItem.getStyle()), null, 0)
            skeletonView.layoutParams =
                LinearLayout.LayoutParams(skeletonItem.wightDp.getDp(itemView.context).toInt(),
                    skeletonItem.heightDp.getDp(itemView.context).toInt())
            (skeletonView.layoutParams as LinearLayout.LayoutParams).setMargins(
                skeletonItem.margin.getDp(itemView.context).toInt(),
                skeletonItem.margin.getDp(itemView.context).toInt(),
                marginSkeleton,
                skeletonItem.margin.getDp(itemView.context).toInt())

            skeletonView.setOnLongClickListener {
                onUserClickListener.invoke(skeletonItem)
                true
            }

            rootContainerView.addView(skeletonView)
        }
    }
}


//class SkeletonViewHolder(
//    private val binding: SkeletonItemBinding,
//    private val onUserClickListener: OnUserClickListener,
//) : BaseViewHolder(binding.root) {
//
//    override fun bind(item: SkeletonModel) = with(binding) {
//        item.name = item.skeletonShape.name
//        binding.root.setBackgroundResource(item.getColor())
//        root.addView(
//            View(ContextThemeWrapper(itemView.context, item.getStyle()),
//                null,
//                0).apply {
//                layoutParams =
//                    LinearLayout.LayoutParams(item.wightDp.getDp(itemView.context).toInt(),
//                        item.heightDp.getDp(itemView.context).toInt())
//                (layoutParams as LinearLayout.LayoutParams).setMargins(
//                    item.margin.getDp(itemView.context).toInt(),item.margin.getDp(itemView.context).toInt(),0,item.margin.getDp(itemView.context).toInt())
//                setOnLongClickListener {
//                    onUserClickListener.invoke(item)
//                    true
//                }
//            }
//        )
//    }
//}
//
//class SkeletonHeaderViewHolder(
//    private val binding: SkeletoneHeaderBinding,
//) : BaseViewHolder(binding.root) {
//
//    override fun bind(item: SkeletonModel) {
//        binding.textViewHeader.text = item.name
//    }
//}

abstract class BaseViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    abstract fun bind(item: SkeletonModelList)

    companion object {
        const val VIEW_TYPE_TOP_NEWS = 0
        const val VIEW_TYPE_TOP_NEWS_HEADER = 1
        const val VIEW_TYPE_SEARCH_NEWS = 2
        const val VIEW_TYPE_FAVORITES_NEWS = 3
        const val VIEW_TYPE_HISTORY_NEWS = 4
        const val VIEW_TYPE_HISTORY_HEADER = 5
    }
}


