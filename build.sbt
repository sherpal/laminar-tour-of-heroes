name := "laminar-tour-of-heroes"

version := "0.1"

scalaVersion := "2.12.8"

enablePlugins(ScalaJSPlugin)
libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % "0.9.5",
  "com.raquo" %%% "laminar" % "0.6",
  "com.lihaoyi" %%% "scalatags" % "0.6.7"
)
scalaJSUseMainModuleInitializer := true
