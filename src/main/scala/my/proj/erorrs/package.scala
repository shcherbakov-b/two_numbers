package my.proj

package object errors {

  case class DomainError(message: String) extends Exception

}
