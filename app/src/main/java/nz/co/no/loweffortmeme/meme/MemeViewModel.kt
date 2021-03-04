package nz.co.no.loweffortmeme.meme

import android.graphics.drawable.Drawable
import android.text.SpannedString
import androidx.annotation.DrawableRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import nz.co.no.loweffortmeme.app.base.BaseViewModel
import nz.co.no.loweffortmeme.app.data.DataRepositoryContract
import nz.co.no.loweffortmeme.app.dumbParseMarkdown

class MemeViewModel(private val dataRepo: DataRepositoryContract, private val drawableResResolver: (Int) -> Drawable): BaseViewModel<MemeEvent>() {
    private val _liveTopText = MutableLiveData("Initial **wtf**")
    val liveTopText: LiveData<SpannedString> = _liveTopText.map { it.dumbParseMarkdown() }

    private val _liveBottomText = MutableLiveData("Spittake **wtf**")
    val liveBottomText: LiveData<SpannedString> = _liveBottomText.map {
        it.dumbParseMarkdown()
    }

    private val _liveFormat = MutableLiveData<MemeFormat>(MemeFormat.all.first())
    val liveNoRes: LiveData<Drawable> = _liveFormat.map { drawableResResolver(it.noDrawableRes) }
    val liveYesRes: LiveData<Drawable> = _liveFormat.map { drawableResResolver(it.yesDrawableRes) }

    fun onCreate() {
        _liveTopText.postValue(dataRepo.getTopText())
        _liveBottomText.postValue(dataRepo.getBottomText())
    }

    fun nextFormat() {
        val current = _liveFormat.value ?: MemeFormat.DrakeFormat
        var index = MemeFormat.all.indexOf(current) + 1

        if (MemeFormat.all.size == index) {
            index = 0
        }

        _liveFormat.postValue(MemeFormat.all.get(index))
    }
}