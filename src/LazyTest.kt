class LazyTest {

    private val someData: DataTest by lazy {
        DataTest("holiwi").also {
            println("Lazy logic is being executed: $it")
        }
    }

    // only if we call this method, someData will be initialized
    fun show() {
        println(someData.someValue)
    }

    fun showDefault() {
        println("Not using any lazy logic")
    }
}