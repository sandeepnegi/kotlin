// MINIFICATION_THRESHOLD: 511
package foo

fun box(): String {
    assertEquals(true, fizz(true) || buzz(true) && (fizz(false) || buzz(true)))
    assertEquals("fizz(true);", pullLog())

    return "OK"
}