package ClassesAndObjects




class Address{
    var size:Int=0
        get() = this.name.length;
    var name: String = "jingtongyuan"
        get() = field
    var street: String = "chaoyang"
    var city: String = "beijing"
    var state: String? ="1"
    var zip: String = "10010"
}

fun main(args: Array<String>) {
    var address:Address=Address()
    println(address.size)
    println(address.name)
}