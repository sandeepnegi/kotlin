// MINIFICATION_THRESHOLD: 511
interface I {
    val foo: String
        get() = "OK"
}

class A : I

fun box() = A().foo