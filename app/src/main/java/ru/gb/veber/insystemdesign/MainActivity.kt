package ru.gb.veber.insystemdesign

import android.content.res.Configuration
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import ru.gb.veber.insystemdesign.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


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