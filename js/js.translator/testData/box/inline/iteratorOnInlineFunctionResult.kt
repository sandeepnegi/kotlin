// MINIFICATION_THRESHOLD: 612
package foo

inline fun bar(f: () -> Int): Array<Int> = arrayOf(f())

fun box(): String {
    val iterator = bar { 23 }.iterator()
    assertEquals(true, iterator.hasNext())
    assertEquals(23, iterator.next())
    assertEquals(false, iterator.hasNext())

    return "OK"
}