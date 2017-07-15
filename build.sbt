name := "DemystifySpark"

version := "1.0"

scalaVersion := "2.11.6"

val sparkVersion = "1.6.2"

libraryDependencies += "org.apache.spark" %% "spark-core" % sparkVersion

assemblyJarName in assembly := s"${name.value}-${version.value}.jar"

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", xs@_*) => MergeStrategy.discard
  case x => MergeStrategy.first
}