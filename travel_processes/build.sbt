lazy val root = (project in file(".")).
  settings(
    version := "1.0",
    organization := "com.chrispottsdev.projects",
    scalaVersion := "2.12.8"
  )

libraryDependencies ++= Seq (
  "org.scalatest"   %% "scalatest"                    % "3.0.1"
)

mainClass in (Compile,run) := Some("com.chrispottsdev.projects.travel.Runner")

mainClass in assembly := Some("com.chrispottsdev.projects.travel.Runner")

assemblyJarName in assembly := "TSTexercise.jar"

assemblyMergeStrategy in assembly :={
  case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
  case _ => MergeStrategy.first
}