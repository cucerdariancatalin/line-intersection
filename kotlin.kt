data class Point(val x: Double, val y: Double)
data class Line(val p1: Point, val p2: Point)

fun intersect(a: Line, b: Line): Point? {
    // Calculate the difference between the x and y coordinates of the endpoints of the lines
    val dax = a.p2.x - a.p1.x
    val dbx = b.p2.x - b.p1.x
    val day = a.p2.y - a.p1.y
    val dby = b.p2.y - b.p1.y

    // Calculate the determinant of the coefficients of the two lines
    val determinant = dax * dby - day * dbx

    // If the determinant is 0, the lines are parallel and do not intersect
    if (determinant == 0.0) {
        return null
    }

    // Calculate the x and y coordinate of the intersection point
    val ax = a.p1.x
    val bx = b.p1.x
    val ay = a.p1.y
    val by = b.p1.y
    val r = (day * (bx - ax) - dax * (by - ay)) / determinant
    val s = (dby * (bx - ax) - dbx * (by - ay)) / determinant

    // If the intersection point is outside the range of the line segments, return null
    if (r < 0 || r > 1 || s < 0 || s > 1) {
        return null
    }

    // Return the intersection point
    return Point(b.p1.x + dbx * r, b.p1.y + dby * r)
}
