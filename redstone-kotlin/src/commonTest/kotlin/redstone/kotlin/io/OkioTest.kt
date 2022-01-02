package redstone.kotlin.io

import okio.Path.Companion.toPath
import kotlin.test.Test
import kotlin.test.assertTrue

@Test
fun testContains() = listOf("", "/", "\\aa").forEach { prefix ->
    assertTrue("${prefix}aa/bb/cc".toPath() in "${prefix}aa/bb".toPath())
    assertTrue("${prefix}aa/bb/cc/..".toPath() in "${prefix}aa/bb".toPath())
    assertTrue("${prefix}aa/bb/cc/.././.".toPath() in "${prefix}aa/bb".toPath())
    assertTrue("${prefix}aa/bb/cc/../..".toPath() !in "${prefix}aa/bb".toPath())
}
