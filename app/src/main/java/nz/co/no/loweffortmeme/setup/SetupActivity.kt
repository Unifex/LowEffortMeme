package nz.co.no.loweffortmeme.setup

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import nz.co.no.loweffortmeme.R
import nz.co.no.loweffortmeme.databinding.ActivitySetupBinding
import nz.co.no.loweffortmeme.meme.MemeActivity
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * Every good joke needs a setup...
 */
class SetupActivity: AppCompatActivity() {
    private lateinit var binding: ActivitySetupBinding
    private val viewModel: SetupViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_setup)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        observeViewModelEvents()
    }

    private fun observeViewModelEvents() {
        viewModel.liveEvents.observe(this, {
            when(it){
                is SetupEvent.ContinueClicked -> startActivity(MemeActivity.getIntent(this))
            }
        })
    }
}