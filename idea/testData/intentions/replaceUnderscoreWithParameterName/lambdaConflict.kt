fun foo(f: (a: Int, b: Int, c: Int) -> Int) {
    f(1, 2, 3)
}

fun bar(c: Int) {
    foo { _, _, <caret>_ -> c }
}
