package ru.gb.veber.insystemdesign

import android.content.res.Configuration
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import ru.gb.veber.insystemdesign.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val newsAdapter = SkeletonAdapter {
        Toast.makeText(this,getToastModel(it), Toast.LENGTH_LONG).show()
    }

    private fun getToastModel(item:SkeletonModel): String {
        return "Style:${item.skeletonShape}\nSize: wightDp:${item.wightDp} heightDp:${item.heightDp}\nColor:${item.colorShape}"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initView()
    }

    private fun initView() {
        binding.recyclerNews.adapter = newsAdapter

        binding.recyclerNews.layoutManager = GridLayoutManager(this, 3)
            .apply {
                spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                    override fun getSpanSize(position: Int): Int {
                        return if (position==0||position==4||position==8) 3 else 1
                    }
                }
            }
        newsAdapter.setList(getList())
    }

    private fun getList(): List<SkeletonModel> {
        return listOf(
            SkeletonModel(
                name = "Primary",
                skeletonShape = SkeletonShape.SkeletonCirclePrimary,
                colorBackground = SkeletonTypeColor.Primary,
                viewType = 1),
            SkeletonModel(
                colorShape = "#dbe2eb",
                skeletonShape = SkeletonShape.SkeletonRectangleSmallPrimary,
                colorBackground = SkeletonTypeColor.Primary),
            SkeletonModel(
                colorShape = "#dbe2eb",
                skeletonShape = SkeletonShape.SkeletonRectangleMediumPrimary,
                colorBackground = SkeletonTypeColor.Primary),
            SkeletonModel(
                colorShape = "#dbe2eb",
                skeletonShape = SkeletonShape.SkeletonCirclePrimary,
                colorBackground = SkeletonTypeColor.Primary),
            SkeletonModel(
                name = "Secondary",
                skeletonShape = SkeletonShape.SkeletonCirclePrimary,
                colorBackground = SkeletonTypeColor.Primary,
                viewType = 1),
            SkeletonModel(
                colorShape = "#1c1c1c",
                skeletonShape = SkeletonShape.SkeletonRectangleSmallSecondary,
                colorBackground = SkeletonTypeColor.Secondary),
            SkeletonModel(
                colorShape = "#1c1c1c",
                skeletonShape = SkeletonShape.SkeletonRectangleMediumSecondary,
                colorBackground = SkeletonTypeColor.Secondary),
            SkeletonModel(
                colorShape = "#1c1c1c",
                skeletonShape = SkeletonShape.SkeletonCircleSecondary,
                colorBackground = SkeletonTypeColor.Secondary),
            SkeletonModel(
                name = "Games",
                skeletonShape = SkeletonShape.SkeletonCirclePrimary,
                colorBackground = SkeletonTypeColor.Primary,
                viewType = 1),
            SkeletonModel(
                colorShape = "#2a4564",
                skeletonShape = SkeletonShape.SkeletonRectangleSmallGames,
                colorBackground = SkeletonTypeColor.Games),
            SkeletonModel(
                colorShape = "#2a4564",
                skeletonShape = SkeletonShape.SkeletonRectangleMediumGames,
                colorBackground = SkeletonTypeColor.Games),
            SkeletonModel(
                colorShape = "#2a4564",
                skeletonShape = SkeletonShape.SkeletonCircleGames,
                colorBackground = SkeletonTypeColor.Games),
        )
    }

    fun getWight() {

        //        binding.testVIew.setBackgroundResource(R.drawable.skeleton_circle)
//        binding.testVIew.backgroundTintList =
//            ContextCompat.getColorStateList(this, R.color.ColorBackground)
//
//        var x = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 65f, resources.displayMetrics)
//
//        val b = View(ContextThemeWrapper(this, R.style.SkeletonStyleRectangleGames16), null, 0).apply {
//            layoutParams = LinearLayout.LayoutParams(x.toInt(),x.toInt())
//        }
//
//        binding.rootLinear.addView(b)


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