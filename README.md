# Scala-notes
## First Scala App
### Using maven to manage project
```bash
mkdir -p ${YOUR_WORK_DIR}/bigdata/scala
cd ${YOUR_WORK_DIR}/bigdata/scala
touch pom.xml
```
### Create pom.xml
```css
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
