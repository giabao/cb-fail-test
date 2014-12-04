import java.util.concurrent.TimeUnit

import com.couchbase.client.java.{AsyncBucket, CouchbaseCluster}
import Helper._
import scala.concurrent.duration._

class FailTest extends CBSpecBase {
  lazy val cluster = CouchbaseCluster.fromConnectionString(connectionString)
  def openBucket(name: String): AsyncBucket = cluster.openBucket(name, pw).async()

  "CouchbaseCluster" should "open an additional bucket while running onNext of a Subscriber of the Observable return by opening first bucket" in {
    openBucket(bk1).upsert(doc).toScala.flatMap { _ =>
      openBucket(bk2).upsert(doc).toScala
    }.timeout(5.seconds)
      .toBlocking
      .toFuture
      .futureValue
      .content === doc.content
  }

  override protected def afterAll() = cluster.disconnect(5, TimeUnit.SECONDS)
}
