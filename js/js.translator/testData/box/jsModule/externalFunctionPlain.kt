// MINIFICATION_THRESHOLD: 508
package foo

@JsModule("lib")
@JsNonModule
external fun foo(y: Int): Int = definedExternally

fun box(): String {
    assertEquals(65, foo(42))
    return "OK"
}