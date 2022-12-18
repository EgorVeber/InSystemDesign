package ru.gb.veber.insystemdesign


import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.view.ContextThemeWrapper
import androidx.core.view.marginBottom
import androidx.core.view.setMargins
import androidx.recyclerview.widget.RecyclerView
import ru.gb.veber.insystemdesign.databinding.EmptyViewBinding


class SkeletonAdapter() : RecyclerView.Adapter<SourcesViewHolder>() {

    var sources: List<SkeletonModel> = emptyList()

    fun setList(list: List<SkeletonModel>) {
        sources = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourcesViewHolder {
        return SourcesViewHolder(EmptyViewBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: SourcesViewHolder, position: Int) {
        holder.bind(sources[position])
    }

    override fun getItemCount() = sources.size
}

class SourcesViewHolder(
    private val binding: EmptyViewBinding,
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(item: SkeletonModel) = with(binding) {
        var x = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 65f, itemView.context.resources.displayMetrics)
        var margin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 25f, itemView.context.resources.displayMetrics)
        val b = View(ContextThemeWrapper(itemView.context, R.style.SkeletonStyleRectangleGames16), null, 0).apply {
            layoutParams = LinearLayout.LayoutParams(x.toInt(),x.toInt())
            setOnClickListener{
                Log.d("TAG", position.toString())
            }
            (layoutParams as LinearLayout.LayoutParams).setMargins(margin.toInt())
        }

       root.addView(b)
//        val someLayout: View = View(root.context, AttributeSet,0,ContextWrapper R.style.SkeletonStyleCircleGames))
//
//
//        val myButton = Button(root.context, null, 0)
//        myButton.layoutParams = LinearLayout.LayoutParams(
//            LinearLayout.LayoutParams.MATCH_PARENT,
//            LinearLayout.LayoutParams.MATCH_PARENT)
//        root.addView(myButton)


//        if (item.isLike) imageFavorites.setImageResource(R.drawable.ic_favorite_36_active)
//        else imageFavorites.setImageResource(R.drawable.ic_favorite_36)
//
//        name.text = item.name
//        description.text = item.description
//        category.text = item.category
//        language.text = item.language
//        country.text = item.country
//        totalFavorites.text = item.totalFavorites.toString()
//        totalHistory.text = item.totalHistory.toString()
//
//
//        openNewsSources.setOnClickListener {
//            listener.newsClick(item.idSources, item.name)
//        }
//
//        openWebSiteSources.setOnClickListener {
//            listener.openUrl(item.url)
//        }
//
//        imageFavorites.setOnClickListener {
//            listener.imageClick(item)
//        }
    }
}
