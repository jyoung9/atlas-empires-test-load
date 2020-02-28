/* AE Load Test Project Build */
ThisBuild / organization := "com.cerberusinteractve"

// Project
lazy val TowarCommunicationProtobufOrleansGatling = (project in file("."))
.settings(
    name := "Towar-Communication-Protobuf-Orleans-Gatling"
)

// Gatling
enablePlugins(GatlingPlugin)
libraryDependencies += "io.gatling.highcharts" % "gatling-charts-highcharts" % "3.3.1" % "test,it"
libraryDependencies += "io.gatling"            % "gatling-test-framework"    % "3.3.1" % "test,it"

// Scala
scalaVersion := "2.12.10"
scalacOptions := Seq(
  "-encoding", "UTF-8", "-target:jvm-1.8", "-deprecation",
  "-feature", "-unchecked", "-language:implicitConversions", "-language:postfixOps"
)

// ScalaPB
PB.targets in Compile := Seq(
  scalapb.gen() -> (sourceManaged in Compile).value
)
libraryDependencies += "com.thesamet.scalapb" %% "scalapb-runtime" % scalapb.compiler.Version.scalapbVersion % "protobuf"