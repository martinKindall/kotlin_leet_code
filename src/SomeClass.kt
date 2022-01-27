class SomeClass(firstVal: Int) {
    private val firstVal: Int

    // init initializes the properties and has access
    // to the parameters received in the primary constructor
    init {
        this.firstVal = firstVal
    }

    constructor(firstVal: Int, secondVal: Int) : this(firstVal) {

    }
}