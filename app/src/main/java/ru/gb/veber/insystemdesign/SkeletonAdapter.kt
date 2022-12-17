package ru.gb.veber.insystemdesign

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.gb.veber.insystemdesign.databinding.SkeletonPrimaryItemBinding

class SkeletonAdapter() : RecyclerView.Adapter<SourcesViewHolder>() {

    var sources: List<SkeletonModel> = emptyList()

    fun setList(list: List<SkeletonModel>) {
        sources = list
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SourcesViewHolder {
        return SourcesViewHolder(SkeletonPrimaryItemBinding.inflate(LayoutInflater.from(parent.context),
            parent,
            false))
    }

    override fun onBindViewHolder(holder: SourcesViewHolder, position: Int) {
        holder.bind(sources[position])
    }

    override fun getItemCount() = sources.size
}

class SourcesViewHolder(
    private val binding: SkeletonPrimaryItemBinding,
) : RecyclerView.ViewHolder(binding.root) {

    @SuppressLint("SetTextI18n")
    fun bind(item: SkeletonModel) = with(binding) {

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
