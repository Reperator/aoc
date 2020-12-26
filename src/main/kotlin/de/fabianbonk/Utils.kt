@file:Suppress("NOTHING_TO_INLINE")

package de.fabianbonk

/**
 * Apply [block] to [this] [times] times.
 */
inline fun <T> T.iterate(times: Int, block: (T) -> T): T {
    var current = this
    for (i in 0 until times) {
        current = block(current)
    }
    return current
}

/**
 * @return whether the bit at [index] in [this] is set.
 */
inline operator fun Byte.get(index: Int): Boolean {
    if (index !in 0 until Byte.SIZE_BITS) {
        throw IndexOutOfBoundsException("index ($index) is not within [0, ${Byte.SIZE_BITS}).")
    }
    return this.toInt()[index]
}

/**
 * @return whether the bit at [index] in [this] is set.
 */
inline operator fun Short.get(index: Int): Boolean {
    if (index !in 0 until Short.SIZE_BITS) {
        throw IndexOutOfBoundsException("index ($index) is not within [0, ${Short.SIZE_BITS}).")
    }
    return this.toInt()[index]
}

/**
 * @return whether the bit at [index] in [this] is set.
 */
inline operator fun Int.get(index: Int): Boolean {
    if (index !in 0 until Int.SIZE_BITS) {
        throw IndexOutOfBoundsException("index ($index) is not within [0, ${Int.SIZE_BITS}).")
    }
    return this and (1 shl index) != 0
}

/**
 * @return whether the bit at [index] in [this] is set.
 */
inline operator fun Long.get(index: Int): Boolean {
    if (index !in 0 until Long.SIZE_BITS) {
        throw IndexOutOfBoundsException("index ($index) is not within [0, ${Long.SIZE_BITS}).")
    }
    return this and (1L shl index) != 0L
}

/**
 * @return [this] interpreted as the bits of a [Byte].
 */
inline fun List<Boolean>.toByte(): Byte {
    if (size !in 0 until Byte.SIZE_BITS) {
        throw IllegalArgumentException("size ($size) is not within [0, ${Byte.SIZE_BITS}).")
    }
    return toInt().toByte()
}

/**
 * @return [this] interpreted as the bits of a [Short].
 */
inline fun List<Boolean>.toShort(): Short {
    if (size !in 0 until Short.SIZE_BITS) {
        throw IllegalArgumentException("size ($size) is not within [0, ${Short.SIZE_BITS}).")
    }
    return toInt().toShort()
}

/**
 * @return [this] interpreted as the bits of an [Int].
 */
inline fun List<Boolean>.toInt(): Int {
    if (size !in 0 until Int.SIZE_BITS) {
        throw IllegalArgumentException("size ($size) is not within [0, ${Int.SIZE_BITS}).")
    }
    return fold(0) { acc, b ->
        (acc shl 1) or if (b) 1 else 0
    }
}

/**
 * @return [this] interpreted as the bits of a [Long].
 */
inline fun List<Boolean>.toLong(): Long {
    if (size !in 0 until Long.SIZE_BITS) {
        throw IllegalArgumentException("size ($size) is not within [0, ${Long.SIZE_BITS}).")
    }
    return fold(0L) { acc, b ->
        (acc shl 1) or if (b) 1L else 0L
    }
}
