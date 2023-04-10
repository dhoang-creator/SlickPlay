package models

import com.github.tminglei.slickpg.{ExPostgresProfile, PgArraySupport, PgDate2Support, PgJsonSupport, PgPlayJsonSupport}
import play.api.libs.json.{JsValue, Json}
import play.api.mvc.BodyParsers.utils

trait CustomPostgresProfile
  extends ExPostgresProfile
  with PgJsonSupport
  with PgPlayJsonSupport
  with PgArraySupport
  with PgDate2Support {

  override def pgjson = "jsonb"
  override protected def computeCapabilities: Set[slick.basic.Capability] =
    super.computeCapabilities + slick.jdbc.JdbcCapabilities.insertOrUpdate

  override val api = CustomPGAPI
  object CustomPGAPI
    extends API
    with JsonImplicits
    with ArrayImplicits
    with DateTimeImplicits {

    implicit val strListTypeMapper = new SimpleArrayJdbcType[String]("text").to(_.toList)
  }
}

object CustomPostgresProfile extends CustomPostgresProfile
