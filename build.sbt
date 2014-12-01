name := "cb-fail-test"
version := "1.0"
scalaVersion := "2.11.4"

libraryDependencies ++= Seq(
  "com.couchbase.client"  % "java-client" % "2.0.1",
  "io.reactivex"          %% "rxscala"    % "0.22.0"
)
