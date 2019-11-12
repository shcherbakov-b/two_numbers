package my.proj

import my.proj.domain.DomainNumber
import my.proj.errors.DomainError

package object types {

  type Result = Either[DomainError, DomainNumber]

}
