// !API_VERSION: 1.3
// JVM_TARGET: 1.8
// WITH_RUNTIME

interface Test {
    @kotlin.annotations.JvmDefault
    fun test(): String {
        return inlineProp
    }

    fun testDefaultImpls(): String {
        return inlineProp
    }

    @kotlin.annotations.JvmDefault
    private inline val inlineProp: String
        get() = "OK"

}

class TestClass : Test {

}

fun box(): String {
    val foo = TestClass()
    if (foo.test() != "OK") return "fail: ${foo.test()}"
    return foo.testDefaultImpls()
}