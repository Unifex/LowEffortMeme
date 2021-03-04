package nz.co.no.loweffortmeme.app.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MemeText(
    @SerializedName("top_text")
    val topText: String,
    @SerializedName("bottom_text")
    val bottomText: String
) : Parcelable