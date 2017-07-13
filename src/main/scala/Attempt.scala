import scala.util.{Failure, Success, Try}

/**
  * Created by bauerc on 6/29/17.
  */
abstract class Attempt[+A, +B] {
  def isFailure: Boolean
  def isSuccess: Boolean

  def getAttempt: A
  def getResult: B
}


final case class FailedAttempt[+A, +B](attempt: A, exception: Throwable) extends Attempt[A, B] {
  def isFailure: Boolean = true;
  def isSuccess: Boolean = false;

  def getAttempt: A = attempt
  def getResult = throw exception

}

final case class SuccessfulAttempt[+A, +B](attempt: A, result: B) extends Attempt[A, B] {
  def isFailure: Boolean = false;
  def isSuccess: Boolean = true;

  def getAttempt: A = attempt
  def getResult: B = result
}

object Attempt {
  def apply[A, B](r: A => B, x: A): Attempt[A, B] = {
    val result = Try(r(x))
    result match {
      case Success(v) => SuccessfulAttempt(x, result.get)
      case Failure(ex) => FailedAttempt(x, ex)
    }
  }
}