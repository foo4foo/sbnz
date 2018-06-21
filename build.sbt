name := """sbnz"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.4"

libraryDependencies += guice
libraryDependencies ++= Seq(evolutions, jdbc)

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

libraryDependencies ++= Seq( javaJdbc , cache , javaWs )

libraryDependencies +=  "org.drools" % "drools-core" % "6.3.0.Final"
libraryDependencies +=  "org.drools" % "drools-compiler" % "6.3.0.Final"

resolvers += "public-jboss" at "http://repository.jboss.org/nexus/content/groups/public-jboss/"

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.21"

// https://mvnrepository.com/artifact/org.mindrot/jbcrypt
libraryDependencies += "org.mindrot" % "jbcrypt" % "0.3m"

// https://mvnrepository.com/artifact/com.auth0/java-jwt
libraryDependencies += "com.auth0" % "java-jwt" % "3.3.0"

// https://mvnrepository.com/artifact/org.projectlombok/lombok
libraryDependencies += "org.projectlombok" % "lombok" % "1.18.0" % "provided"
