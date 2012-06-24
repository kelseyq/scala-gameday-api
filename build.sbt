organization := "com.xenopsconsulting"

name := "scala-gameday-api"

version := "0.1.0-SNAPSHOT"

scalaVersion := "2.9.1"

libraryDependencies ++= Seq(
	  "net.databinder" %% "dispatch-http" % "0.8.8",
	  "net.databinder" %% "dispatch-core" % "0.8.7",
	  "org.scalatest" %% "scalatest" % "1.8" % "test"
 )

resolvers += "Sonatype OSS Snapshots" at "http://oss.sonatype.org/content/repositories/snapshots/"
