package redstone.kotlin.io

import okio.Path

/**
 * Tests if a path is a child of another path
 * @param other The possible child path
 */
operator fun Path.contains(other: Path) = other.normalized().toString().startsWith(this.normalized().toString())
