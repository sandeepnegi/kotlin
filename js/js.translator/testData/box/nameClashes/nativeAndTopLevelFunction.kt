// MINIFICATION_THRESHOLD: 504
package test

external fun foo(ignore: dynamic): String

@JsName("foo")
fun foo() = "K"

fun box() = foo(0) + foo()