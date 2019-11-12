package my.proj

import my.proj.services.SquareCounter

object Solution extends App {

  val counter = new SquareCounter()

  println(counter.findCount(6000, 7000))

}