/**
  * Created by bauerc on 6/13/17.
  */
//case class SomeMonad[A](x: A) extends MonadFiddle[A] {
//  def get = x
//}

object MonadFiddle {
  def apply[A](x: A): MonadFiddle[A] = MonadFiddle(x)
}

class MonadFiddle[A](x: A) {
  def get = x

  def flatMap[B](f: A => MonadFiddle[B]): MonadFiddle[B] = {
    f(this.get)
  }

  def map[B](f: A => B): MonadFiddle[B] = {
    MonadFiddle(f(this.get))
  }
}


//def unit[A](x: A): MonadFiddle[A];


