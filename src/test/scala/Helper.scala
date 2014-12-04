import com.couchbase.client.java.document.JsonStringDocument
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.time.{Seconds, Span}
import org.scalatest.{BeforeAndAfterAll, Matchers, FlatSpec}
import rx.lang.scala.JavaConversions._

object Helper {
  implicit class RxToScala[T](val obs: rx.Observable[T]) extends AnyVal {
    def toScala: rx.lang.scala.Observable[T] = toScalaObservable(obs)
  }

  val connectionString = "http://example.com:8091" //TODO update this
  val bk1 = "acc"
  val bk2 = "log"
  val pw = "???" //TODO update this

  val doc = JsonStringDocument.create("key_test", 1000, "value_test")
}

trait CBSpecBase extends FlatSpec with Matchers with ScalaFutures with BeforeAndAfterAll {
  implicit override def patienceConfig: PatienceConfig = PatienceConfig(scaled(Span(15, Seconds)), scaled(Span(1, Seconds)))
}
