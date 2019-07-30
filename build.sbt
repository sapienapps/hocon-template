name := "hocon-template"

resolvers += "jitpack" at "https://jitpack.io"

version := "0.1"

scalaVersion := "2.12.8"

licenses := Seq("MIT License" -> url("https://opensource.org/licenses/MIT"))

homepage := Some(url("https://github.com/sapienapps/hocon-template"))

scmInfo := Some(
  ScmInfo(
    url("https://github.com/sapienapps/hocon-template"),
    "scm:git:ssh://github.com/sapienapps/hocon-template.git"
  )
)

developers := List(
  Developer(
    id    = "jordanburke",
    name  = "Jordan Burke",
    email = "jordan.burke@sapienapps.com",
    url   = url("https://github.com/orgs/sapienapps/people/jordanburke")
  )
)


libraryDependencies ++= {

  Seq(
    "com.typesafe" % "config" % "1.3.3"
  )
}

publishMavenStyle := true
