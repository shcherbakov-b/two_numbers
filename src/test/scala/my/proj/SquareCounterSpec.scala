package my.proj

import my.proj.domain.DomainNumber
import my.proj.errors.DomainError
import my.proj.services.SquareCounter
import org.scalatest.{FlatSpec, Matchers}

class SquareCounterSpec extends FlatSpec with Matchers {

  private val service = new SquareCounter()

  "Square root" should "calculate count correctly in range 10...20" in {
    val result = service.findCount(10, 20)
    result shouldBe Right(DomainNumber(16, 2, 2))
  }

  it should "calculate count correctly in range 120...121" in {
    val result = service.findCount(120, 121)
    result shouldBe Right(DomainNumber(121, 11, 1))
  }

  it should "fail with error" in {
    val result = service.findCount(1, 2)
    result shouldBe Left(DomainError("Requirement failed!"))
  }

  it should "also fail with error if lower bound > upper bound" in {
    val result = service.findCount(20, 10)
    result shouldBe Left(DomainError("Requirement failed!"))
  }

  it should "fail with error if count not found" in {
    val result = service.findCount(101, 101)
    result shouldBe Left(DomainError("Not found!"))
  }

}
