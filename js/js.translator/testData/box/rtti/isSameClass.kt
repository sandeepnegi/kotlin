// MINIFICATION_THRESHOLD: 509
package foo

class A() {

}

fun box(): String {
    assertEquals(true, A() is A)
    return "OK"
}