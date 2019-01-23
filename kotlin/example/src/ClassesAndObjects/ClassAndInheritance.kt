package ClassesAndObjects


class Test

class Test1(name:String)

class Test2(val name:String){
    init {
        println("init name${name}")
    }

    constructor(name:String,age:Int):this(name){
        println("name:"+name+", age:"+age);
    }
}


class Test3(val name:String){

    init {
        println("init name${name}")
    }
    constructor(name:String,age:Int,sex:String="women"):this(name){
        println("name:"+name+", age:"+age+" sex:"+sex);
    }
}
open class  Example {
    open fun fun1(){
        println("Example.fun1")
    }
    fun fun2(){}
}

class Example1:Example(){
    override fun fun1(){
    }
    inner class Baz{
        fun  fun1(){
            println(super@Example1.fun1())
        }
    }

}


fun main(args: Array<String>) {
    var test1:Test1= Test1("test1");

    println(test1)

    var test2:Test2= Test2("test2",18);
    println(test2)

    var test3:Test3= Test3("test3",18);

    println(test3)

    var test4:Test3= Test3("test3",18,"man");

    println(test3)
}