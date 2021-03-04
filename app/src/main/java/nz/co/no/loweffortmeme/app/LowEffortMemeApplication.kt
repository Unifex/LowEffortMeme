package nz.co.no.loweffortmeme.app

import android.app.Application
import nz.co.no.loweffortmeme.app.koin.LowEffortMemeKoin

class LowEffortMemeApplication: Application()  {

    override fun onCreate() {
        super.onCreate()

        LowEffortMemeKoin.start(this)
    }
}