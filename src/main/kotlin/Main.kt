fun main(args: Array<String>) {
    val x = { println("123") }
    x()
    x.invoke() // безопасный

    val y : () -> Unit = { println("Hello")}

    val sum : (Int, Int) -> Int = { x: Int, y: Int -> x + y }
    println(sum(2,3))

    val printer = {message: String -> println(message)}
    printer("Hello")

    val sum2 = {x: Int, y: Int ->
        val result = x + y
        println("$x + $y = $result")
    }
    val sum3 = {x: Int, y: Int -> val result = x + y; println("$x + $y = $result")}

    // лямбды
    doOperation(100,200, {x: Int, y: Int -> x*x + y*y})
    doOperation(100,200) { x: Int, y: Int -> x * x + y * y }

    // анонимная функция
    doOperation(300,400, fun(x: Int, y: Int) = x*y*100 )

    val test = fun(x: Int, y:Int) : Int = x + y
    test(5,6)

    val r1 = bigFun(1)
    println(r1(2,3)) // -1

    example(5,6,fun(x:Int, y: Int) = println("$x $y"))
}

fun example(x: Int, y: Int, test: (Int, Int) -> Unit) {
    test(x,y)
}

fun bigFun(k : Int) : (Int, Int) -> Int {
    when(k) {
        1 -> return fun(x: Int, y: Int) = x - y
        2 -> return fun(x: Int, y: Int) = 200*x*y
        else -> return fun(x: Int, y: Int) = 100
    }
}

fun doOperation(a: Int, b: Int, op: (Int, Int) -> Int) {
    val res = op(a,b)
    println("Res = $res")
}
