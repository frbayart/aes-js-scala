name := "hello"

version := "1.0"

//scalaVersion := "2.12"

libraryDependencies ++= Seq(
  "commons-codec" % "commons-codec" % "1.10",
  "commons-io" % "commons-io" % "2.4"
)


libraryDependencies += "org.apache.commons" % "commons-compress" % "1.14"


mainClass := Some("com.francois.Encrypt.main")
