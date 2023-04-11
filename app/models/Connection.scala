package models

import slick.jdbc.H2Profile.api._

object Connection {
  val db = Database.forConfig("postgres")
  val InMemDb = Database.forConfig("h2mem1")
}
