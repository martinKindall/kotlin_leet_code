import kotlin.properties.Delegates

class LateInitTests {
    lateinit var greetObj: OpenClass

    fun initClass() {
        greetObj = GreetingClass("hi")
    }

    fun greet() {
        // if greetObj has not been initialized, this fill throw an Exception
        // UninitializedPropertyAccessException: lateinit var not initialized
        greetObj.greeting()
    }
}