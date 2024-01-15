ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.3"

lazy val root = (project in file("."))
  .settings(
    name := "ejemplo",
    libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.6.18",
    libraryDependencies += "com.typesafe.akka" %% "akka-slf4j" % "2.6.18"
  )
