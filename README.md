# Scala-notes
## First Scala App
### Using maven to manage project
```bash
mkdir -p ${YOUR_WORK_DIR}/bigdata/scala
cd ${YOUR_WORK_DIR}/bigdata/scala
touch pom.xml
```
### Create pom.xml
```html
<project>
  <modelVersion>4.0.0</modelVersion>
  <groupId>ca.jrvs</groupId>
  <artifactId>scala</artifactId>
  <version>1.0-SNAPSHOT</version>
  <name>${project.artifactId}</name>
   <properties>
    <encoding>UTF-8</encoding>
    <scala.version>2.11.6</scala.version>
  </properties>

  <dependencies>
    <dependency>
      <groupId>org.scala-lang</groupId>
      <artifactId>scala-library</artifactId>
      <version>${scala.version}</version>
    </dependency>

    <dependency>
      <groupId>org.scalatest</groupId>
      <artifactId>scalatest_2.11</artifactId>
      <version>2.2.5</version>
      <scope>compile</scope>
    </dependency>
  </dependencies>

  <build>
    <plugins>
      <plugin>
        <groupId>org.scala-tools</groupId>
        <artifactId>maven-scala-plugin</artifactId>
        <version>2.15.2</version>
        <executions>
          <execution>
            <goals>
              <goal>compile</goal>
              <goal>testCompile</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
      <plugin>
        <groupId>org.scalatest</groupId>
        <artifactId>scalatest-maven-plugin</artifactId>
        <version>1.0</version>
        <configuration>
        </configuration>
        <executions>
          <execution>
            <id>test</id>
            <goals>
              <goal>test</goal>
            </goals>
          </execution>
        </executions>
      </plugin>
    </plugins>
  </build>
</project>
```
### Simple project demo
- Clear appliation structrue
```sh
cd ${YOUR_WORK_DIR}/bigdata/scala
mkdir -p src/main.scala/ca/jrvs
scr/main/scala/ca/jrvs/App.scala
```
- Simple "Hello World!" application
```scala
package ca.jrvs
object App {
	def foo(x : Array[String])  = x.foldLeft("")((a,b)=>a + b)
	def main(args:Array[String]) {
		println("hello world!")
		println("concat arguments = " + foo(args))
	}
}
```
### Install IntelliJ Scala Plugin
### Import this project to IntelliJ(YEAH!We get there!)
![](https://github.com/keshang-xxpk/Scala-notes/blob/master/Assest/Screen%20Shot%202019-09-19%20at%201.21.50%20PM.png)
## IntelliJ Scala Worksheet
We can use Scala console to run simple scala code by right click ->Run Scala Console,the thing is if you quit the console you will lose the history,so alternatively we can create a Scala Worksheet.
![](https://github.com/keshang-xxpk/Scala-notes/blob/master/Assest/Screen%20Shot%202019-09-19%20at%201.31.34%20PM.png)
## Learing Scala
### Basics:
#### Useful tutorial I use:
- video:https://www.codequizzes.com/scala/tutorial
- twitter scala school:https://twitter.github.io/scala_school
#### Here has more resources may help you:
- Offical tuorial:
	- https://docs.scala-lang.org/tour/basics.html
	- https://docs.scala-lang.org/tour/unified-types.html
- Tutorial video:
	- https://docs.scala-lang.org/overviews/scaladoc/interface.html
#### Simple Demo on worksheet
- Expressions
```scala
1 + 1 //res0: Int = 2
```
res0 is an automatically created value name given by the interpreter to the result of your expression. It has the type Int and contains the Integer 2.(Almost) everything in Scala is an expression.
- Values
```scala
val two = 1 + 1//two: Int = 2
var name = "ke"//name: String = ke
```
If you need to change the binding, you can use a var instead.
- Functions
You can create functions with def.
```scala
def addOne(m: Int):Int = m + 1//addOne: (m: Int)Int
```
In Scala, you need to specify the type signature for function parameters. The interpreter happily repeats the type signature back to you.

```scala
val three = addOne(2)//three: Int = 3
```
You can leave off parens on functions with no arguments.
```scala
def four() = 2 + 2//four: ()Int
four()//res1: Int = 4
```
- Anonymous Functions
You can create anonymous functions.
```scala
(x:Int)=>x + 1//res2: Int => Int = <function>
```
This function adds 1 to an Int named x.
```scala
res2(1)//res3: Int = 2
```
You can pass anonymous functions around or save them into vals.
```scala
val addTwo = (x:Int)=>x + 2//addTwo: Int => Int = <function>

addTwo(2)//res4: Int = 4
```
If your function is made up of many expressions, you can use {} to give yourself some breathing room.
```scala
def timesTwo(i:Int): Int = {//timesTwo: (i: Int)Int
  println("hello World")//hello World
  i * 2
}
```
This is also true of an anonymous function.
```scala
timesTwo(2)//res5: Int = 4

val timesThree={//timesThree: Int => Int = <function>
  i:Int =>println("hello world")
    i * 3
}//hello world
timesThree(3)//res6: Int = 9
```
- Partial application
You can partially apply a function with an underscore, which gives you another function. Scala uses the underscore to mean different things in different contexts, but you can usually think of it as an unnamed magical wildcard. In the context of { _ + 2 } it means an unnamed parameter. You can use it like so:
```scala
def adder(m:Int,n:Int) = m + n//adder: (m: Int, n: Int)Int
val add2 = adder(2,_:Int)//add2: Int => Int = <function>
add2(3)//res7: Int = 5
```
- Curried functions
Sometimes it makes sense to let people apply some arguments to your function now and others later.

Here’s an example of a function that lets you build multipliers of two numbers together. At one call site, you’ll decide which is the multiplier and at a later call site, you’ll choose a multiplicand.
```scala
def multiply(m:Int)(n:Int):Int = m * n//multiply: (m: Int)(n: Int)Int
multiply(2)(3)//res8: Int = 6
```
You can fill in the first parameter and partially apply the second.
```scala
val timesFour = multiply(4)_//timesFour: Int => Int = <function>
timesFour(3)//res9: Int = 12
```
- Variable length arguments
There is a special syntax for methods that can take parameters of a repeated type. To apply String’s capitalize function to several strings, you might write:
```scala
def capitalizeAll(args:String*) = {//capitalizeAll: (args: String*)Seq[String]
  args.map {
    arg => arg.capitalize
  }
}
capitalizeAll("rarity","appledog")//res10: Seq[String] = ArraySeq(Rarity, Appledog)
```
- Classes
```scala
class Calculator {
  var brand: String = "HP"
  def add(m: Int, n: Int):Int = m + n
}//defined class Calculator

val calc = new Calculator//calc: Calculator = Calculator@781896fc
calc.add(1,2)//res11: Int = 3
calc.brand//res12: String = HP
```
Contained are examples defining methods with def and fields with val. Methods are just functions that can access the state of the class.

- Constructor
Constructors aren’t special methods, they are the code outside of method definitions in your class. Let’s extend our Calculator example to take a constructor argument and use it to initialize internal state.
```scala
class Calculator2(brant:String) {
  var color : String = if (brant == "TI") {
  "blue"
  } else if (brant == "HP"){
    "black"
  }else {
    "white"
  } 
  def add(m:Int,n:Int) : Int = m + n
}//defined class Calculator2
```
Note the two different styles of comments.

You can use the constructor to construct an instance:
```scala
val calc2 = new Calculator2("TI")//calc2: Calculator2 = Calculator2@6d484872
calc2.color//res13: String = blue
calc2.add(1,2)//res14: Int = 3
```
- Abstract Classes
You can define an abstract class, a class that defines some methods but does not implement them. Instead, subclasses that extend the abstract class define these methods. You can’t create an instance of an abstract class.
```scala
abstract class Shape {
  def getArea():Int
}//defined class Shape

class Circle(r:Int) extends Shape {
  def getArea() : Int = {r * r * 3}
}//defined class Circle

val s = new Circle(2)//s: Circle = Circle@7d74ce21
```
- Traits
traits are collections of fields and behaviors that you can extend or mixin to your classes.
```scala
trait Car {
  val brand:String
}//defined trait Car
trait Shiny {
  val shineRefraction: Int
}//defined trait Shiny

class BMW extends Car {
  val brand = "BMW"
}defined class BMW
```
One class can extend several traits using the with keyword:
```scala
class BMW2 extends Car with Shiny {
  val brand = "BMW2"
  val shineRefraction = 12
}//defined class BMW2
```
- Types
Earlier, you saw that we defined a function that took an Int which is a type of Number. Functions can also be generic and work on any type. When that occurs, you’ll see a type parameter introduced with the square bracket syntax. Here’s an example of a Cache of generic Keys and Values.

```scala
trait Cache[K,V] {
  def get(key:K) : V
  def put(key:K,value:V)
  def delete(key:K)
}defined trait Cache
```

