package ru.gb.veber.insystemdesign

import android.content.ContextWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.ListPopupWindow.MATCH_PARENT
import android.widget.TextView
import androidx.appcompat.view.ContextThemeWrapper
import androidx.core.content.ContextCompat
import androidx.core.view.setMargins
import androidx.recyclerview.widget.RecyclerView
import ru.gb.veber.insystemdesign.databinding.SkeletonItemAllBinding

typealias OnUserClickListener = (login: SkeletonModel) -> Unit


class SkeletonAdapter(private val onUserClickListener: OnUserClickListener) :
    RecyclerView.Adapter<BaseViewHolder>() {

    var skeletonList: List<SkeletonModelList> = emptyList()

    fun setList(list: List<SkeletonModelList>) {
        skeletonList = list
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int): Int {
        return skeletonList[position].viewType
    }

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

        if (itemViewType == SKELETON_TYPE) {


            binding.rootContainerView.setBackgroundResource(item.getColor())
            item.listSkeleton.forEachIndexed { index, skeletonItem ->
                var marginSkeleton =
                    if (index == item.listSkeleton.size - 1) skeletonItem.margin.getDp(itemView.context)
                        .toInt() else 0

                val skeletonView =
                    View(ContextThemeWrapper(itemView.context, skeletonItem.getStyle()), null, 0)
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
        } else {
            var skeletonHeaderView = TextView(rootContainerView.context)
            skeletonHeaderView.text = item.nameLineView
            skeletonHeaderView.setTextColor(ContextCompat.getColor(itemView.context,
                R.color.ColorTextPrimary))
            skeletonHeaderView.textSize = 25f
            skeletonHeaderView.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,FrameLayout.LayoutParams.WRAP_CONTENT)
            (skeletonHeaderView.layoutParams as LinearLayout.LayoutParams).marginStart = item.margin.getDp(itemView.context).toInt()
            rootContainerView.addView(skeletonHeaderView)
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
        const val SKELETON_TYPE = 0
        const val SKELETON_HEADER_TYPE = 1
    }
}


