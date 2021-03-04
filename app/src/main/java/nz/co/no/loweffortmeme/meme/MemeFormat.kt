package nz.co.no.loweffortmeme.meme

import androidx.annotation.DrawableRes
import nz.co.no.loweffortmeme.R

sealed class MemeFormat(@DrawableRes val yesDrawableRes: Int,
                        @DrawableRes val noDrawableRes: Int) {

    object DrakeFormat: MemeFormat(R.drawable.drake_yes, R.drawable.drake_no)
    object ElonFormat: MemeFormat(R.drawable.elon_yes, R.drawable.elon_no)


    companion object{
        val all = listOf(
            DrakeFormat,
            ElonFormat
        )
    }
}