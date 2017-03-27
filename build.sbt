name := """hello-play-java"""

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  "org.webjars" %% "webjars-play" % "2.2.2", 
  "org.webjars" % "bootstrap" % "2.3.1")

libraryDependencies ++= Seq(  
  javaJdbc,
  javaEbean,
  cache
)

//An explicit Scala version is required
scalaVersion := "2.10.4"  

lazy val root = (project in file(".")).enablePlugins(PlayJava)


fork in run := true