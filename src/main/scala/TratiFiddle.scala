/**
  * Created by bauerc on 4/19/17.
  */

trait testTrait {
  val s = "I am a test"
}

class TratiFiddle extends testTrait{
  val a = "I am also a test"
  def apply() = println(s)
  def apply(x: Int) = x + 2

}
