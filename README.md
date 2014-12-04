See https://www.couchbase.com/issues/browse/JVMCBC-79

1. update Helper.{connectionString, pw}

2. checkout [couchbase-jvm-core](https://github.com/couchbase/couchbase-jvm-core) & run `./gradlew publishToMavenLocal`

3. checkout [couchbase-java-client](https://github.com/couchbase/couchbase-java-client) & run `./gradlew publishToMavenLocal`

4. install [sbt](http://www.scala-sbt.org/0.13/tutorial/Manual-Installation.html)

5. run `sbt test` =>

[log/sbt_test_log.txt](log/sbt_test_log.txt)

### Note
The previous tests is at previous [commits](https://github.com/giabao/cb-fail-test/commits/master)
