import com.couchbase.client.java.{AsyncBucket, CouchbaseAsyncCluster}
import rx.lang.scala.JavaConversions._
import rx.lang.scala.Observable
import scala.concurrent.duration._
import Helper._

object SuccessTest extends App {
  val cluster = CouchbaseAsyncCluster.fromConnectionString(connectionString)
  def openBucket(name: String): Observable[AsyncBucket] = cluster.openBucket(name, pw).toScala

  openBucket(bk1).flatMap { bk =>
    bk.upsert(doc).toScala.flatMap { _ =>
      openBucket(bk2).flatMap(_.upsert(doc))
    }
  }.timeout(5.seconds)
    .toBlocking
    .foreach(d => print(d.content))
}
