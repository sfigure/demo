package ClassesAndObjects

class TestE(){
    val  bar:Int=0;
    fun foo1(){

    }
}


fun TestE.foo1(){
    println("Extension functions")
}

fun main(args: Array<String>) {
    var test1:TestE=TestE()
    test1.foo1();
}