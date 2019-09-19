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
def addOne(m: Int):Int = m + 1//addOne: (m: Int)Int
val three = addOne(2)//three: Int = 3

def four() = 2 + 2//four: ()Int
four()//res1: Int = 4

(x:Int)=>x + 1//res2: Int => Int = <function>
res2(1)//res3: Int = 2
val addTwo = (x:Int)=>x + 2//addTwo: Int => Int = <function>
addTwo(2)//res4: Int = 4

def timesTwo(i:Int): Int = {//timesTwo: (i: Int)Int
  println("hello World")//hello World
  i * 2
}
timesTwo(2)//res5: Int = 4

val timesThree={//timesThree: Int => Int = <function>
  i:Int =>println("hello world")
    i * 3
}//hello world
timesThree(3)//res6: Int = 9

def adder(m:Int,n:Int) = m + n//adder: (m: Int, n: Int)Int
val add2 = adder(2,_:Int)//add2: Int => Int = <function>
add2(3)//res7: Int = 5

def multiply(m:Int)(n:Int):Int = m * n//multiply: (m: Int)(n: Int)Int
multiply(2)(3)//res8: Int = 6
val timesFour = multiply(4)_//timesFour: Int => Int = <function>
timesFour(3)//res9: Int = 12

def capitalizeAll(args:String*) = {//capitalizeAll: (args: String*)Seq[String]
  args.map {
    arg => arg.capitalize
  }
}
capitalizeAll("rarity","appledog")//res10: Seq[String] = ArraySeq(Rarity, Appledog)

class Calculator {
  var brand: String = "HP"
  def add(m: Int, n: Int):Int = m + n
}//defined class Calculator

val calc = new Calculator//calc: Calculator = Calculator@781896fc
calc.add(1,2)//res11: Int = 3
calc.brand//res12: String = HP

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

val calc2 = new Calculator2("TI")//calc2: Calculator2 = Calculator2@6d484872
calc2.color//res13: String = blue
calc2.add(1,2)//res14: Int = 3

abstract class Shape {
  def getArea():Int
}//defined class Shape

class Circle(r:Int) extends Shape {
  def getArea() : Int = {r * r * 3}
}//defined class Circle

val s = new Circle(2)//s: Circle = Circle@7d74ce21
trait Car {
  val brand:String
}//defined trait Car
trait Shiny {
  val shineRefraction: Int
}//defined trait Shiny

class BMW extends Car {
  val brand = "BMW"
}defined class BMW

class BMW2 extends Car with Shiny {
  val brand = "BMW2"
  val shineRefraction = 12
}defined class BMW2

trait Cache[K,V] {
  def get(key:K) : V
  def put(key:K,value:V)
  def delete(key:K)
}defined trait Cache


