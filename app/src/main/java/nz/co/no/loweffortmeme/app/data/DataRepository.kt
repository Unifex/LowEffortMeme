package nz.co.no.loweffortmeme.app.data

import android.app.Application
import androidx.annotation.RawRes
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import nz.co.no.loweffortmeme.R
import nz.co.no.loweffortmeme.app.models.MemeText

class DataRepository(private val context: Application, private val gson: Gson): DataRepositoryContract {
    private val _meme: MemeText by lazy {
        readRawResource(R.raw.meme_text)
    }

    override fun getTopText() = _meme.topText
    override fun getBottomText() = _meme.bottomText

    private inline fun <reified T> readRawResource(@RawRes id: Int): T {
        val reader = context.resources.openRawResource(id).bufferedReader()
        val type = object : TypeToken<T>() {}.type

        return gson.fromJson(reader,type)
    }
}