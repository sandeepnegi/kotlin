// MINIFICATION_THRESHOLD: 508
package foo

object A {
    object B {
        val lambda = { "OK" }
    }
}

fun box() = A.B.lambda()

