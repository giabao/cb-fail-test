import com.couchbase.client.java.document.JsonStringDocument
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
