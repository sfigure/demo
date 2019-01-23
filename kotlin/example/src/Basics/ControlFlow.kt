package Basics

fun main(args: Array<String>) {



//    只有表达式有返回值哦
//    var a=for (i in 1..100){
//
//    }

//    var aa=while (){
//
//    }
    val a: Int = 5;
    val b: Int = 6;
    val max = if (a > b) {
        a
    } else {
        b
    }


    println(max);

    println("aa".repeat(20))


    val w = when (max) {
        1 -> max
        else -> {
            20
        }
    }

    println(w);

    val w1 = when (max) {
        in 1..10 -> 10
        in 10..100 -> 100
        else -> {
            200
        }
    }
    println(w1);

}