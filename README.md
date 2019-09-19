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
### Import this project to IntelliJ
