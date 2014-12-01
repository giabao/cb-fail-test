1. update Helper.{connectionString, pw}

2. run SuccessTest => success:

```
Dec 01, 2014 6:48:52 PM com.couchbase.client.core.CouchbaseCore <init>
INFO: CoreEnvironment: {sslEnabled=false, sslKeystoreFile='null', sslKeystorePassword='null', queryEnabled=false, queryPort=8093, bootstrapHttpEnabled=true, bootstrapCarrierEnabled=true, bootstrapHttpDirectPort=8091, bootstrapHttpSslPort=18091, bootstrapCarrierDirectPort=11210, bootstrapCarrierSslPort=11207, ioPoolSize=4, computationPoolSize=4, responseBufferSize=16384, requestBufferSize=16384, kvServiceEndpoints=1, viewServiceEndpoints=1, queryServiceEndpoints=1, ioPool=NioEventLoopGroup, coreScheduler=CoreScheduler, packageNameAndVersion=couchbase-java-client/2.0.1 (git: 2.0.1)}
Dec 01, 2014 6:48:52 PM com.couchbase.client.core.node.CouchbaseNode$5 call
INFO: Connected to Node example.com
Dec 01, 2014 6:48:53 PM com.couchbase.client.core.config.DefaultConfigurationProvider$6 call
INFO: Opened bucket acc
Dec 01, 2014 6:48:53 PM com.couchbase.client.core.config.DefaultConfigurationProvider$6 call
INFO: Opened bucket log
value_test
Process finished with exit code 0
```

3. run FailTest => fail:

```
Dec 01, 2014 6:41:10 PM com.couchbase.client.core.CouchbaseCore <init>
INFO: CoreEnvironment: {sslEnabled=false, sslKeystoreFile='null', sslKeystorePassword='null', queryEnabled=false, queryPort=8093, bootstrapHttpEnabled=true, bootstrapCarrierEnabled=true, bootstrapHttpDirectPort=8091, bootstrapHttpSslPort=18091, bootstrapCarrierDirectPort=11210, bootstrapCarrierSslPort=11207, ioPoolSize=4, computationPoolSize=4, responseBufferSize=16384, requestBufferSize=16384, kvServiceEndpoints=1, viewServiceEndpoints=1, queryServiceEndpoints=1, ioPool=NioEventLoopGroup, coreScheduler=CoreScheduler, packageNameAndVersion=couchbase-java-client/2.0.1 (git: 2.0.1)}
Dec 01, 2014 6:41:10 PM com.couchbase.client.core.node.CouchbaseNode$5 call
INFO: Connected to Node example.com
Dec 01, 2014 6:41:11 PM com.couchbase.client.core.config.DefaultConfigurationProvider$6 call
INFO: Opened bucket acc
Exception in thread "main" java.lang.RuntimeException: java.util.concurrent.TimeoutException
	at rx.observables.BlockingObservable.forEach(BlockingObservable.java:138)
	at rx.lang.scala.observables.BlockingObservable$.foreach$extension(BlockingObservable.scala:53)
	at FailTest$.delayedEndpoint$FailTest$1(FailTest.scala:5)
	at FailTest$delayedInit$body.apply(FailTest.scala:5)
	at scala.Function0$class.apply$mcV$sp(Function0.scala:40)
	at scala.runtime.AbstractFunction0.apply$mcV$sp(AbstractFunction0.scala:12)
	at scala.App$$anonfun$main$1.apply(App.scala:76)
	at scala.App$$anonfun$main$1.apply(App.scala:76)
	at scala.collection.immutable.List.foreach(List.scala:381)
	at scala.collection.generic.TraversableForwarder$class.foreach(TraversableForwarder.scala:35)
	at scala.App$class.main(App.scala:76)
	at FailTest$.main(FailTest.scala:5)
	at FailTest.main(FailTest.scala)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:483)
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:134)
Caused by: java.util.concurrent.TimeoutException
	at rx.internal.operators.OperatorTimeoutBase$TimeoutSubscriber.onTimeout(OperatorTimeoutBase.java:169)
	at rx.internal.operators.OperatorTimeout$1$1.call(OperatorTimeout.java:42)
	at rx.internal.schedulers.ScheduledAction.run(ScheduledAction.java:45)
	at java.util.concurrent.Executors$RunnableAdapter.call(Executors.java:511)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.access$201(ScheduledThreadPoolExecutor.java:180)
	at java.util.concurrent.ScheduledThreadPoolExecutor$ScheduledFutureTask.run(ScheduledThreadPoolExecutor.java:293)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)

Process finished with exit code 1
```