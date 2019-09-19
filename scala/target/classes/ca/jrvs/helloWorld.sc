1 + 1
val two = 1 + 1
var name = "ke"

def addOne(m: Int):Int = m + 1
val three = addOne(2)

def four() = 2 + 2
four()

(x:Int)=>x + 1
res2(1)
val addTwo = (x:Int)=>x + 2
addTwo(2)

def timesTwo(i:Int): Int = {
  println("hello World")
  i * 2
}
timesTwo(2)

val timesThree={
  i:Int =>println("hello world")
    i * 3
}
timesThree(3)

def adder(m:Int,n:Int) = m + n
val add2 = adder(2,_:Int)
add2(3)

def multiply(m:Int)(n:Int):Int = m * n
multiply(2)(3)
val timesFour = multiply(4)_
timesFour(3)

def capitalizeAll(args:String*) = {
  args.map {
    arg => arg.capitalize
  }
}
capitalizeAll("rarity","appledog")

class Calculator {
  var brand: String = "HP"
  def add(m: Int, n: Int):Int = m + n
}

val calc = new Calculator
calc.add(1,2)
calc.brand

class Calculator2(brant:String) {
  var color : String = if (brant == "TI") {
  "blue"
  } else if (brant == "HP"){
    "black"
  }else {
    "white"
  }
  def add(m:Int,n:Int) : Int = m + n
}

val calc2 = new Calculator2("TI")
calc2.color
calc2.add(1,2)

abstract class Shape {
  def getArea():Int
}
class Circle(r:Int) extends Shape {
  def getArea() : Int = {r * r * 3}
}

val s = new Circle(2)
trait Car {
  val brand:String
}
trait Shiny {
  val shineRefraction: Int
}

class BMW extends Car {
  val brand = "BMW"
}

class BMW2 extends Car with Shiny {
  val brand = "BMW2"
  val shineRefraction = 12
}

trait Cache[K,V] {
  def get(key:K) : V
  def put(key:K,value:V)
  def delete(key:K)
}





