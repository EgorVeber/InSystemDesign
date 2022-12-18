package ru.gb.veber.insystemdesign

import android.content.res.Configuration
import android.util.DisplayMetrics
import android.util.Log

object RepoSkeletonModel {
    fun getList(): List<SkeletonModel> {
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

    fun getListAll(): List<SkeletonModelList> {
        return listOf(
            SkeletonModelList(
                listOf(
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
                        colorBackground = SkeletonTypeColor.Primary)),
                SkeletonTypeColor.Primary),
            SkeletonModelList(
                listOf(
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
                        colorBackground = SkeletonTypeColor.Secondary)),
                SkeletonTypeColor.Secondary),
            SkeletonModelList(
                listOf(
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
                        colorBackground = SkeletonTypeColor.Games)),
                SkeletonTypeColor.Games))
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


//        val displayMetrics = DisplayMetrics()
//        windowManager.defaultDisplay.getMetrics(displayMetrics)
//        val width = displayMetrics.widthPixels
//
//        Log.d("TAG", "width = $width")
//
//        val configuration: Configuration = this.resources.configuration
//        //Текущая ширина доступного пространства экрана в единицах dp, соответствующая квалификатору ресурса ширины экрана.
//        val screenWidthDp: Int = configuration.screenWidthDp
//
//        //Наименьший размер экрана, который приложение увидит при нормальной работе, соответствующий квалификатору ресурса наименьшей ширины экрана.
//        val smallestScreenWidthDp: Int = configuration.smallestScreenWidthDp
//
//        Log.d("TAG", "screenWidthDp = $screenWidthDp")
//        Log.d("TAG", "smallestScreenWidthDp = $smallestScreenWidthDp")
    }

}