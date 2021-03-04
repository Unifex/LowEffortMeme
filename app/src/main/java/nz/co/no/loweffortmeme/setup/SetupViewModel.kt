package nz.co.no.loweffortmeme.setup

import nz.co.no.loweffortmeme.app.base.BaseViewModel
import nz.co.no.loweffortmeme.app.data.DataRepositoryContract

class SetupViewModel() : BaseViewModel<SetupEvent>() {
    fun continueClicked() = postEvent(SetupEvent.ContinueClicked)
}