import com.couchbase.client.java.{AsyncBucket, CouchbaseCluster}
import Helper._
import scala.concurrent.duration._

object FailTest extends App {
  val cluster = CouchbaseCluster.fromConnectionString(connectionString)
  def openBucket(name: String): AsyncBucket = cluster.openBucket(name, pw).async()

  openBucket(bk1).upsert(doc).toScala.flatMap { _ =>
    openBucket(bk2).upsert(doc).toScala
  }.timeout(5.seconds)
    .toBlocking
    .foreach(d => print(d.content))
}
