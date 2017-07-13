/**
  * Created by bauerc on 4/19/17.
  */
object ScalaFiddle {

  def main(args: Array[String]): Unit = {
    val traitFiddle =  new TratiFiddle()

    println(traitFiddle.s)
    println(traitFiddle.a)
    traitFiddle()
    println(traitFiddle(2))
//    Option[TratiFiddle]


  }
}
