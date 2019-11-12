package my.proj.services

import cats.implicits._
import my.proj.domain.DomainNumber
import my.proj.errors.DomainError
import my.proj.services.SquareCounter._
import my.proj.types.Result

import scala.annotation.tailrec

class SquareCounter {

  def findCount(lowerBound: Int, upperBound: Int): Result = {

    @tailrec
    def square(number: DomainNumber): DomainNumber = {
      val withCount = number.multiply
      if (upperBound >= withCount.square) square(withCount)
      else number
    }

    @tailrec
    def find(current: Result): Result = {
      val next = current.map(c => square(c.nextNumber))
      if (current.exists(c => c.square >= lowerBound && next.exists(_.count < c.count)))
        current
      else if (current.exists(c => c.count == 0 && c.square * c.square > upperBound))
        DomainError("Not found!").asLeft
      else find(next)
    }

    if (lowerBound <= upperBound && lowerBound >= MinRestriction && upperBound <= MaxRestriction)
      find(square(DomainNumber(2, 2)).asRight)
    else DomainError("Requirement failed!").asLeft

  }

}

object SquareCounter {

  val MinRestriction = 2

  val MaxRestriction = 2000000000
}
