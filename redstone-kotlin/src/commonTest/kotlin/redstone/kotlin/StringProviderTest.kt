package redstone.kotlin

import kotlin.test.Test
import kotlin.test.assertEquals

class StringProviderTest {

    @Test
    fun shouldProvide233() {
        val underTest = StringProvider()
        assertEquals("233", underTest.provideString())
    }
}
