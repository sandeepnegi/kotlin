// MINIFICATION_THRESHOLD: 504
package foo

fun Any.foo(n: Int): () -> Boolean {
    var count = n
    return { --count >= 0 }
}

fun box(): String {
    return if (1.foo(3)() && !1.foo(0)()) "OK" else "fail"
}
