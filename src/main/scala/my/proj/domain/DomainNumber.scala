package my.proj.domain

import scala.math.BigInt

case class DomainNumber(square: BigInt, initial: Int, count: Int = 0) {
  def multiply: DomainNumber = copy(square = square * square, count = count + 1)
  def nextNumber: DomainNumber = copy(initial = initial + 1, count = 0, square = initial + 1)
}
