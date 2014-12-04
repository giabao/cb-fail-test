See https://www.couchbase.com/issues/browse/JVMCBC-79

1. update Helper.{connectionString, pw}

2. checkout [couchbase-jvm-core](https://github.com/couchbase/couchbase-jvm-core) & run `./gradlew publishToMavenLocal`

3. checkout [couchbase-java-client](https://github.com/couchbase/couchbase-java-client) & run `./gradlew publishToMavenLocal`

4. install [sbt](http://www.scala-sbt.org/0.13/tutorial/Manual-Installation.html)

5. run `sbt test` =>

```
> test
[info] Updating {file:/C:/oss/cb-fail-test/}cb-fail-test...
[info] Resolving org.scala-lang#scala-library;2.11.4 ...
[info] Resolving com.couchbase.client#java-client;2.0.2-SNAPSHOT ...
 [info] Resolving com.couchbase.client#java-client;2.0.2-SNAPSHOT ...
 [info] Resolving com.couchbase.client#core-io;1.0.2-SNAPSHOT ...
 [info] Resolving com.couchbase.client#core-io;1.0.2-SNAPSHOT ...
 [info] Resolving io.reactivex#rxjava;1.0.2 ...
 [info] Resolving io.reactivex#rxscala_2.11;0.22.0 ...
 [info] Resolving org.scalatest#scalatest_2.11;2.2.2 ...
 [info] Resolving org.scala-lang#scala-reflect;2.11.2 ...
 [info] Resolving org.scala-lang.modules#scala-xml_2.11;1.0.2 ...
 [info] Resolving org.scala-lang#scala-compiler;2.11.4 ...
 [info] Resolving org.scala-lang#scala-reflect;2.11.4 ...
 [info] Resolving org.scala-lang.modules#scala-parser-combinators_2.11;1.0.2 ...
 [info] Resolving jline#jline;2.12 ...
[info] Done updating.
[info] Compiling 3 Scala sources to C:\oss\cb-fail-test\target\scala-2.11\test-classes...
Dec 04, 2014 4:23:52 PM com.couchbase.client.core.env.DefaultCoreEnvironment <init>
WARNING: More than 1 Couchbase Environments found (2), this can have severe impact on performance and stability. Reuse environments!
Dec 04, 2014 4:23:52 PM com.couchbase.client.core.CouchbaseCore <init>
INFO: CoreEnvironment: {sslEnabled=false, sslKeystoreFile='null', sslKeystorePassword='null', queryEnabled=false, queryPort=8093, bootstrapHttpEnabled=true, bootstrapCarrierEnabled=true, bootstrapHttpDirectPort=8091, bootstrapHttpSslPort=18091, bootstrapCarrierDirectPort=11210, bootstrapCarrierSslPort=11207, ioPoolSize=4, computationPoolSize=4, responseBufferSize=16384, requestBufferSize=16384, kvServiceEndpoints=1, viewServiceEndpoints=1, queryServiceEndpoints=1, ioPool=NioEventLoopGroup, coreScheduler=CoreScheduler, packageNameAndVersion=couchbase-java-client/2.0.2-SNAPSHOT (git: 2.0.1-13-g4317ebe-dirty)}
Dec 04, 2014 4:23:52 PM com.couchbase.client.core.CouchbaseCore <init>
INFO: CoreEnvironment: {sslEnabled=false, sslKeystoreFile='null', sslKeystorePassword='null', queryEnabled=false, queryPort=8093, bootstrapHttpEnabled=true, bootstrapCarrierEnabled=true, bootstrapHttpDirectPort=8091, bootstrapHttpSslPort=18091, bootstrapCarrierDirectPort=11210, bootstrapCarrierSslPort=11207, ioPoolSize=4, computationPoolSize=4, responseBufferSize=16384, requestBufferSize=16384, kvServiceEndpoints=1, viewServiceEndpoints=1, queryServiceEndpoints=1, ioPool=NioEventLoopGroup, coreScheduler=CoreScheduler, packageNameAndVersion=couchbase-java-client/2.0.2-SNAPSHOT (git: 2.0.1-13-g4317ebe-dirty)}
Dec 04, 2014 4:23:53 PM com.couchbase.client.core.node.CouchbaseNode$5 call
INFO: Connected to Node example.com
Dec 04, 2014 4:23:53 PM com.couchbase.client.core.node.CouchbaseNode$5 call
INFO: Connected to Node example.com
Dec 04, 2014 4:23:53 PM com.couchbase.client.core.config.DefaultConfigurationProvider$6 call
INFO: Opened bucket acc
Dec 04, 2014 4:23:53 PM com.couchbase.client.core.config.DefaultConfigurationProvider$6 call
INFO: Opened bucket acc
Dec 04, 2014 4:23:53 PM com.couchbase.client.core.config.DefaultConfigurationProvider$6 call
INFO: Opened bucket log
Dec 04, 2014 4:23:53 PM com.couchbase.client.core.config.DefaultConfigurationProvider$9 call
INFO: Closed bucket acc
Dec 04, 2014 4:23:53 PM com.couchbase.client.core.config.DefaultConfigurationProvider$9 call
INFO: Closed bucket log
Dec 04, 2014 4:23:53 PM com.couchbase.client.core.node.CouchbaseNode$5 call
INFO: Disconnected from Node example.com
[info] SuccessTest:
[info] CouchbaseAsyncCluster
[info] - should open an additional bucket while running onNext of a Subscriber of the Observable return by opening first bucket
Dec 04, 2014 4:23:58 PM com.couchbase.client.core.config.DefaultConfigurationProvider$6 call
INFO: Opened bucket log
Dec 04, 2014 4:23:59 PM com.couchbase.client.core.config.DefaultConfigurationProvider$9 call
INFO: Closed bucket acc
Dec 04, 2014 4:23:59 PM com.couchbase.client.core.config.DefaultConfigurationProvider$9 call
INFO: Closed bucket log
Dec 04, 2014 4:23:59 PM com.couchbase.client.core.node.CouchbaseNode$5 call
INFO: Disconnected from Node example.com
[info] FailTest:
[info] CouchbaseCluster
[info] - should open an additional bucket while running onNext of a Subscriber of the Observable return by opening first bucket *** FAILED ***
[info]   The future returned an exception of type: java.util.concurrent.TimeoutException. (FailTest.scala:17)
[info] Run completed in 9 seconds, 508 milliseconds.
[info] Total number of tests run: 2
[info] Suites: completed 2, aborted 0
[info] Tests: succeeded 1, failed 1, canceled 0, ignored 0, pending 0
[info] *** 1 TEST FAILED ***
[error] Failed tests:
[error]         FailTest
[error] (test:test) sbt.TestsFailedException: Tests unsuccessful
[error] Total time: 17 s, completed Dec 4, 2014 4:24:01 PM
```

### Note
The previous test is at commit [3f12ac2331](https://github.com/giabao/cb-fail-test/blob/3f12ac2331/README.md)
