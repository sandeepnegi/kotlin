// MINIFICATION_THRESHOLD: 502
package foo

fun box(): String {
    var x = 2;
    do {
        x = 1;
    }
    while (3 < 2)
    if (x == 1) {
        return "OK"
    }
    return "fail: $x"
}

