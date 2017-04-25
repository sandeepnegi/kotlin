// MINIFICATION_THRESHOLD: 511
interface I {
    fun foo() = "OK"
}

class A : I

fun box() = A().foo()