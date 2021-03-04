package nz.co.no.loweffortmeme.app.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<T : BaseEvent>: ViewModel() {

    private val _liveEvents = MutableLiveData<T>()
    val liveEvents: LiveData<T> = _liveEvents

    fun postEvent(event: T) {
        _liveEvents.postValue(event)
    }
}