// MINIFICATION_THRESHOLD: 506
// This test was adapted from compiler/testData/codegen/box/callableReference/function/.
package foo

class A {
    var result = "OK"
}

fun box() = (::A)().result
