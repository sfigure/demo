package Basics

fun main(args: Array<String>) {
    val a:Int? = null;  //a 允许空值

    val b1:Int=1;
    val b:Long?=b1.toLong();

    val  c1=0xFF;
    val  c3=0b11111111;
    println(c1);
    println(c3);
    println(Int.MAX_VALUE);
    var text="""
        java1也能这样写了0.0
        java也能这样写了0.0
        java也能这样写了0.0
        java也能这样写了0.0
        java也能这样写了0.0
        java也能这样写了0.0
        java也能这样写了0.0
        java也能这样写了0.0
    """.trimIndent()

    var text1="""
        java2也能这样写了0.0
        java也能这样写了0.0
        java也能这样写了0.0
        java也能这样写了0.0
        java也能这样写了0.0
        java也能这样写了0.0
        java也能这样写了0.0
        java也能这样写了0.0




    """.trimEnd()
    var text2="""


        java3也能这样写了0.0
        java也能这样写了0.0
        java也能这样写了0.0
        java也能这样写了0.0
        java也能这样写了0.0
        java也能这样写了0.0
        java也能这样写了0.0
        java也能这样写了0.0
    """.trimMargin()
    print(text);
    print(text1);
    print(text2);



    var language:String="kotlin";

    var stringTemplate:String="hello $language  ${1+1}";
    print(stringTemplate);


}