package nz.co.no.loweffortmeme.app.koin

import android.app.Application
import com.google.gson.GsonBuilder
import nz.co.no.loweffortmeme.app.data.DataRepository
import nz.co.no.loweffortmeme.app.data.DataRepositoryContract
import nz.co.no.loweffortmeme.meme.MemeViewModel
import nz.co.no.loweffortmeme.setup.SetupViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module

object  LowEffortMemeKoin {

    @JvmStatic
    fun start(application: Application) {
        startKoin {
            androidLogger()
            androidContext(application)
            modules(listOf(
                remoteDataModule,
                setupModule,
                memeModule
            ))
        }
    }

    private val remoteDataModule = module {
        single {
            GsonBuilder()
                .create()
        }

        single<DataRepositoryContract> {
            DataRepository(
                context = get(),
                gson = get()
            )
        }
    }

    private val setupModule = module {
        viewModel {
            SetupViewModel()
        }
    }

    private val memeModule = module {
        viewModel {
            MemeViewModel(
                dataRepo = get(),
                drawableResResolver = { resId ->
                    //Oof, I don't like a bang bang
                    androidContext().getDrawable(resId)!!
                }
            )
        }
    }
}