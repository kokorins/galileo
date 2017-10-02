organization := "scala"

name := "Galileo"

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.2"

scalacOptions ++= Seq( "-deprecation", "-feature" )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
libraryDependencies += "org.scala-lang.modules" % "scala-jline" % "2.12.1"
libraryDependencies += "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.6"


