// MINIFICATION_THRESHOLD: 502
fun box(): String {
    return js("""
        function foo() {
            return "OK";
        }
        foo();
    """)
}