name := "cb-fail-test"
version := "1.0"
scalaVersion := "2.11.4"

resolvers += Resolver.mavenLocal

libraryDependencies ++= Seq(
  "com.couchbase.client"  % "java-client" % "2.0.2-SNAPSHOT", //at commit 4317ebe46c
  "com.couchbase.client"  % "core-io"     % "1.0.2-SNAPSHOT", //at commit 35e5791cae
  "io.reactivex"          %% "rxscala"    % "0.22.0",
  "org.scalatest"         %% "scalatest"  % "2.2.2" % "test"
)
