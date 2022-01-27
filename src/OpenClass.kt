abstract class OpenClass {

    protected abstract val lastName: String

    fun greeting() {
        println("Hi there! Welcome aboard ${this.name()} $lastName")
    }

    open fun name(): String = "(No name)"
}


class GreetingClass(hello: String): OpenClass() {

    override val lastName: String = "Cornejo"

    // One class can have simultaneously primary and secondary
    // constructors.
    constructor(hello: String, hola: String) : this(hello) {
    }

    override fun name(): String {
        return "Martin"
    }

    companion object {
        fun sayHello() {
            println("Hi there")
        }
    }
}