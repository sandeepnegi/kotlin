// MINIFICATION_THRESHOLD: 510
package foo

class Test() {
    val a: Int
        get() {
            return 5;
        }
}

fun box(): String {
    var test = Test()
    return if (test.a == 5) "OK" else "fail: ${test.a}"
}