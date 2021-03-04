package nz.co.no.loweffortmeme.meme

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import nz.co.no.loweffortmeme.R
import nz.co.no.loweffortmeme.databinding.ActivityMemeBinding
import org.koin.android.viewmodel.ext.android.viewModel

/**
 * https://www.youtube.com/watch?v=qA__K0Fx1mo
 */
class MemeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMemeBinding
    private val viewModel: MemeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_meme)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        observeViewModelEvents()
        viewModel.onCreate()
    }

    private fun observeViewModelEvents() {
        viewModel.liveEvents.observe(this, {
            when(it){

            }
        })
    }

    companion object {
        @JvmStatic
        fun getIntent(context: Context) = Intent(context, MemeActivity::class.java).apply {
            //Normally I'd add any intent extras here
        }
    }
}