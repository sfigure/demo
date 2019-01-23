package Basics


fun foo() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return // non-local return directly to the caller of foo()
        print(it)
    }
    println("this point is unreachable")
}

fun foo1() {
    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3) return@lit // local return to the caller of the lambda, i.e. the forEach loop
        print(it)
    }
    print(" done with explicit label")
}

fun foo2() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return@forEach // local return to the caller of the lambda, i.e. the forEach loop
        print(it)
    }
    print(" done with implicit label")
}

fun foo3() {
    listOf(1, 2, 3, 4, 5).forEach(fun(value: Int) {
        if (value == 3) return  // local return to the caller of the anonymous fun, i.e. the forEach loop
        print(value)
    })
    println(" done with anonymous function")
}

fun foo4() {
    run loop@{
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@loop // non-local return from the lambda passed to run
            print(it)
        }
    }
    println(" done with nested loop")
}


fun foo5():Int{
    return run ret@ {
        return@ret 1;
    }
}


fun main(args: Array<String>) {

    foo()
    println("=".repeat(100));
    foo1()
    println("=".repeat(100));
    foo2()
    println("=".repeat(100));
    foo3()
    println("=".repeat(100));
    foo4()
    println("=".repeat(100));
    println(foo5());

    loop1@for(i in 1..100){
        loop2@for(j in 1..100){
            continue@loop1
        }
    }

    loop1@for(i in 1..100){
        loop2@for(j in 1..100){
            break@loop1
            break@loop2
        }
    }



}