package ru.gb.veber.insystemdesign

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import ru.gb.veber.insystemdesign.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val skeletonAdapter = SkeletonAdapter {
        Toast.makeText(this, getToastModel(it), Toast.LENGTH_LONG).show()
    }

    private fun getToastModel(item: SkeletonModel): String {
        return "Style:${item.skeletonShape}\nSize: wightDp:${item.wightDp} heightDp:${item.heightDp}\nColor:${item.colorShape}"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.recyclerNews.adapter = skeletonAdapter
        binding.recyclerNews.layoutManager = LinearLayoutManager(this)
//        var x = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)
//        binding.recyclerNews.layoutManager = x
//            .apply {
//                spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
//                    override fun getSpanSize(position: Int): Int {
//                        return if (position == 0 || position == 4 || position == 8) 3 else 1
//                    }
//                }
//            }
        skeletonAdapter.setList(RepoSkeletonModel.getListAll())
    }
}