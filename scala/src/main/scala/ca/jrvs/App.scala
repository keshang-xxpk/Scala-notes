package ca.jrvs
object App {
	def foo(x : Array[String])  = x.foldLeft("")((a,b)=>a + b)
	def main(args:Array[String]) {
		println("hello world!")
		println("concat arguments = " + foo(args))
	}
}
