sealed class SealedClassExample {

    abstract fun print()

    var aValue = "hi I am here and you will be fine"
        get() = field
        set(value) {
            println("Hi I am being set")
            field = value
        }

    object SomeA : SealedClassExample() {
        override fun print() {
            println("a message")
        }
    }
    object B: SealedClassExample() {
        override fun print() {
            println("Default message is printed")
        }
    }
}