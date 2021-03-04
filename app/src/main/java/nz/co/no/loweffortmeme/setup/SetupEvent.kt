package nz.co.no.loweffortmeme.setup

import nz.co.no.loweffortmeme.app.base.BaseEvent

sealed class SetupEvent: BaseEvent {
    object ContinueClicked: SetupEvent()
}