// MINIFICATION_THRESHOLD: 509
package foo

class A() {
    fun lold() = "OK"

    val p = {
        {
            lold()
        }()
    }
}

fun box(): String {
    return A().p()
}
