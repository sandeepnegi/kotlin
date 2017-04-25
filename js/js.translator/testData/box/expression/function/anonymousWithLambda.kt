// MINIFICATION_THRESHOLD: 504
fun box(): String {
    val a = (fun(): String {
        val o = { "O" }
        return o() + "K"
    })
    return a()
}