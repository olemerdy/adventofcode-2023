ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.1"

ThisBuild / libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.17" % Test

lazy val root = (project in file("."))
  .settings(
    name := "adventofcode-2023"
  )
