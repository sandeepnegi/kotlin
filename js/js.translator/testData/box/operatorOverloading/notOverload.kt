// MINIFICATION_THRESHOLD: 507
package foo

class A() {

    operator fun not() = "OK"

}

fun box() = !A()