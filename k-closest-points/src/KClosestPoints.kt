import java.util.PriorityQueue
import kotlin.math.pow
import kotlin.math.sqrt

fun main() {
    val input = listOf(listOf(1f, 1f), listOf(-1f, 0f), listOf(2f, 2f))
    val points = input.map { Point.fromList(it) }
    val origin = Point(0f, 0f)
    val closestPoints = origin.kClosest(points, 2)
    val output = closestPoints.map { it.toList() }
    println(output) // [[-1, 0], [1,1]]
}

data class Point(val x: Float, val y: Float) {
    private fun distFrom(that: Point): Float {
        return sqrt((this.x - that.x).pow(2) + (this.y - that.y).pow(2))
    }

    fun kClosest(points: List<Point>, k: Int): List<Point> {
        val closestNeighborsPQ = PriorityQueue<Point>(Comparator<Point> { o1, o2 ->
            val d1 = distFrom(o1)
            val d2 = distFrom(o2)
            return@Comparator when {
                d1 < d2 -> -1
                d1 > d2 -> 1
                else -> 0
            }
        })
        closestNeighborsPQ.addAll(points)
        return (0 until k.coerceAtMost(closestNeighborsPQ.size)).map { closestNeighborsPQ.poll() }
    }

    fun toList(): List<Float> = listOf(x, y)

    companion object {
        fun fromList(p: List<Float>): Point = Point(p[0], p[1])
    }
}
