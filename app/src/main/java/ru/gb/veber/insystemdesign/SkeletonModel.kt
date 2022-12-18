package ru.gb.veber.insystemdesign

import android.content.Context
import android.util.TypedValue

data class SkeletonModelList(
    var nameLineView:String,
    var listSkeleton: List<SkeletonModel>,
    val colorBackground: SkeletonTypeColor,
    val margin: Float = 0f,
    val viewType: Int = 0,
)

data class SkeletonModel(
    var name: String? = "",
    val wightDp: Float = 60f,
    val heightDp: Float = 60f,
    val margin: Float = 25f,
    val skeletonShape: SkeletonShape,
    var colorShape: String? = "",
    val colorBackground: SkeletonTypeColor,
    val viewType: Int = 0,
)

fun SkeletonModel.getStyle(): Int {
    return when (this.skeletonShape) {
        SkeletonShape.SkeletonRectangleSmallPrimary -> R.style.SkeletonRectangleSmallPrimary
        SkeletonShape.SkeletonRectangleMediumPrimary -> R.style.SkeletonRectangleMediumPrimary
        SkeletonShape.SkeletonCirclePrimary -> R.style.SkeletonCirclePrimary
        SkeletonShape.SkeletonRectangleSmallSecondary -> R.style.SkeletonRectangleSmallSecondary
        SkeletonShape.SkeletonRectangleMediumSecondary -> R.style.SkeletonRectangleMediumSecondary
        SkeletonShape.SkeletonCircleSecondary -> R.style.SkeletonCirclePrimarySecondary
        SkeletonShape.SkeletonRectangleSmallGames -> R.style.SkeletonRectangleSmallGames
        SkeletonShape.SkeletonRectangleMediumGames -> R.style.SkeletonRectangleMediumGames
        SkeletonShape.SkeletonCircleGames -> R.style.SkeletonCirclePrimaryGames
    }
}

enum class SkeletonShape {
    SkeletonRectangleSmallPrimary,
    SkeletonRectangleMediumPrimary,
    SkeletonCirclePrimary,
    SkeletonRectangleSmallSecondary,
    SkeletonRectangleMediumSecondary,
    SkeletonCircleSecondary,
    SkeletonRectangleSmallGames,
    SkeletonRectangleMediumGames,
    SkeletonCircleGames
}

enum class SkeletonTypeColor {
    Primary,
    Secondary,
    Games
}

fun SkeletonModel.getColor(): Int {
    return when (this.colorBackground) {
        SkeletonTypeColor.Primary -> R.color.ColorContentBackground
        SkeletonTypeColor.Secondary -> R.color.ColorBackgroundLightNight
        SkeletonTypeColor.Games -> R.color.ColorBackgroundLightNight
    }
}

fun SkeletonModelList.getColor(): Int {
    return when (this.colorBackground) {
        SkeletonTypeColor.Primary -> R.color.ColorContentBackground
        SkeletonTypeColor.Secondary -> R.color.ColorBackgroundLightNight
        SkeletonTypeColor.Games -> R.color.ColorBackgroundLightNight
    }
}


fun Float.getDp(context: Context): Float {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
        this,
        context.resources.displayMetrics)
}