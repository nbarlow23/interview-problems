import kotlin.Double.Companion.NEGATIVE_INFINITY
import kotlin.Double.Companion.POSITIVE_INFINITY
import kotlin.math.floor
import kotlin.math.log2

fun main() {
    println(!isPowerOf2(0))
    println(isPowerOf2(1))
    println(isPowerOf2(2))
    println(!isPowerOf2(3))
    println(isPowerOf2(4))
    println(!isPowerOf2(5))
    println(!isPowerOf2(6))
    println(!isPowerOf2(7))
    println(isPowerOf2(8))
    println(!isPowerOf2(9))
    println(!isPowerOf2(10))
    println(!isPowerOf2(11))
    println(!isPowerOf2(12))
    println(!isPowerOf2(13))
    println(!isPowerOf2(14))
    println(!isPowerOf2(15))
    println(isPowerOf2(16))
    println(isPowerOf2(32))
    println(isPowerOf2(64))
    println(isPowerOf2(128))
    println(isPowerOf2(256))
    println(isPowerOf2(512))
    println(isPowerOf2(1024))
    println(isPowerOf2(2048))
}

fun isPowerOf2(num: Int): Boolean {
    val log = log2(num.toDouble())
    if (listOf(NEGATIVE_INFINITY, POSITIVE_INFINITY).contains(log)) return false
    return floor(log) == log
}
