package kamiltomczyk.recruitment.exchangeratesapp

import android.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.annotation.CallSuper
import io.mockk.MockKAnnotations
import io.mockk.unmockkAll
import org.junit.After
import org.junit.Before
import org.junit.Rule

abstract class BaseTest {

    @get:Rule
    val taskRule = InstantTaskExecutorRule()

    /*
    @get:Rule
    val coroutinesRule = CoroutinesRule()
    TODO:Resolve dependency issue
     */

    @Before
    @CallSuper
    open fun initTest() {
        MockKAnnotations.init(this)
    }

    @After
    @CallSuper
    open fun closeTest() {
        unmockkAll()
    }
}