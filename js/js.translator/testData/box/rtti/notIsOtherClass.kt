// MINIFICATION_THRESHOLD: 515
package foo

open class A() {

}

class B() : A() {

}

fun box(): String {
    assertEquals(true, A() !is B)
    return "OK"
}