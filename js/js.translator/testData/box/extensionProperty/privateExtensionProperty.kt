// MINIFICATION_THRESHOLD: 508
class A {
    fun result() = "OK"
}

private val A.foo: String
    get() = result()

fun box() = A().foo