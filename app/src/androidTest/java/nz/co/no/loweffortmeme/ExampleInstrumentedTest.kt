package nz.co.no.loweffortmeme

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun ensure_that_tests_fail() {
        val expected: Boolean = false
        val actual: Boolean = true
        assertEquals("NO!! THIS IS JOKE APP! I REFUSE TO WRITE TESTS!",
            expected, actual)
    }
}