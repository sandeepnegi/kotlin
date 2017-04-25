// MINIFICATION_THRESHOLD: 507
package foo

class A() {

    operator fun div(other: A) = "OK"

}

fun box() = A() / A()