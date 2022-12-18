package ru.gb.veber.insystemdesign

import android.content.res.Configuration
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.ContextThemeWrapper
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import ru.gb.veber.insystemdesign.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val newsAdapter = SkeletonAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.recyclerNews.adapter = newsAdapter
        binding.recyclerNews.layoutManager = LinearLayoutManager(this)
        newsAdapter.setList(getList())

        binding.testVIew.setBackgroundResource(R.drawable.skeleton_shape_circle)
        binding.testVIew.backgroundTintList =
            ContextCompat.getColorStateList(this, R.color.ColorBackground)

        var x = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 65f, resources.displayMetrics)

        val b = View(ContextThemeWrapper(this, R.style.SkeletonStyleRectangleGames16), null, 0).apply {
            layoutParams = LinearLayout.LayoutParams(x.toInt(),x.toInt())
        }

        binding.rootLinear.addView(b)
    }

    fun getList(): List<SkeletonModel> {
        return listOf(
            SkeletonModel(),
            SkeletonModel(),
            SkeletonModel(),
            SkeletonModel(),
            SkeletonModel(),
            SkeletonModel(),
            SkeletonModel(),
            SkeletonModel())
    }

    fun getWight() {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val width = displayMetrics.widthPixels

        Log.d("TAG", "width = $width")

        val configuration: Configuration = this.resources.configuration
        //Текущая ширина доступного пространства экрана в единицах dp, соответствующая квалификатору ресурса ширины экрана.
        val screenWidthDp: Int = configuration.screenWidthDp

        //Наименьший размер экрана, который приложение увидит при нормальной работе, соответствующий квалификатору ресурса наименьшей ширины экрана.
        val smallestScreenWidthDp: Int = configuration.smallestScreenWidthDp

        Log.d("TAG", "screenWidthDp = $screenWidthDp")
        Log.d("TAG", "smallestScreenWidthDp = $smallestScreenWidthDp")
    }
}