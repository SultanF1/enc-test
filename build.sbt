ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "2.12.15"

val sparkVersion = "3.3.2"

lazy val root = (project in file("."))
  .settings(
    name := "pipe",
    libraryDependencies ++= Seq(
      "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
      "org.apache.spark" %% "spark-sql" % sparkVersion % "provided",
      "org.apache.spark" %% "spark-yarn" % sparkVersion % "provided",
      "org.apache.spark" %% "spark-hive" % sparkVersion % "provided",
      "org.apache.hadoop" % "hadoop-client" % "3.3.4" % "provided",
      "org.scala-lang" % "scala-reflect" % "2.13.10" % "provided",
      "com.typesafe" % "config" % "1.4.2",
      "org.bouncycastle" % "bcprov-jdk15on" % "1.70",
      "com.jpmorgan.quorum" % "encryption-api" % "0.11.0.30092019161842",
      "io.github.locke-chappel.oss.commons" % "encryption" % "1.0.1",
      "com.idealista" % "format-preserving-encryption" % "1.0.0"
    )
  ).enablePlugins(AssemblyPlugin)

