import com.couchbase.client.java.{AsyncBucket, CouchbaseAsyncCluster}
import rx.lang.scala.JavaConversions._
import rx.lang.scala.Observable
import scala.concurrent.duration._
import Helper._

class SuccessTest extends CBSpecBase {
  lazy val cluster = CouchbaseAsyncCluster.fromConnectionString(connectionString)
  def openBucket(name: String): Observable[AsyncBucket] = cluster.openBucket(name, pw).toScala

  "CouchbaseAsyncCluster" should "open an additional bucket while running onNext of a Subscriber of the Observable return by opening first bucket" in {
    openBucket(bk1).flatMap { bk =>
      bk.upsert(doc).toScala.flatMap { _ =>
        openBucket(bk2).flatMap(_.upsert(doc))
      }
    }.timeout(5.seconds)
      .toBlocking
      .toFuture
      .futureValue
      .content === doc.content
  }

  override protected def afterAll() = cluster.disconnect().timeout(5.seconds).toBlocking.single
}
