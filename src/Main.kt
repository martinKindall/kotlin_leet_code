import java.lang.StringBuilder

fun main() {
    // dataExperiments()

//    SomeSimpleLogic.greet()
//    SomeSimpleLogic.extendingAClass()

//    GreetingClass("as").apply {
//        greeting()
//    }
//    val someGreet = GreetingClass("")
//     someGreet.sayHello()   // does not work
//    GreetingClass.sayHello()

//    LateInitTests().apply {
//        initClass()
//        greet()
//    }

//    val someLazyObject = LazyTest()
//    someLazyObject.showDefault()
//    someLazyObject.show()

    val sealedEample: SealedClassExample = SealedClassExample.SomeA
    val sealedExample2: SealedClassExample = SealedClassExample.B

    printSealedClasses(listOf(sealedEample, sealedExample2))
}

fun printSealedClasses(sealedObjects: List<SealedClassExample>) {
    sealedObjects.forEach {
        it.print()

        when (it) {
            SealedClassExample.B -> "Era B"
            SealedClassExample.SomeA -> "Era A"
        }

        it.aValue = "hi another value"
    }
}

fun SomeSimpleLogic.extendingAClass() {
    println("I can actually access class properties like $someValue")
}

fun dataExperiments() {
    val someData = DataTest("just testing a data class")
    val someData2 = DataTest("just testing a data class")
    println(someData)
    println(someData == someData2)

    val string1 = "holiwi"
    val string2 = "holiwi"

    val someString1 = StringBuilder()
    someString1.append("holi")
    someString1.append("wi")

    println(string1 == string2)
    println(string1 == someString1.toString())
}
