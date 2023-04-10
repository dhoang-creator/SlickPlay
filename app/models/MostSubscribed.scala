package models

import slick.jdbc.H2Profile.api._
import scala.concurrent.ExecutionContext.Implicits.global

case class MostSubscribedParams(
                         index: Int,
                         channels_name: String,
                         channel_line: String,
                         brand_status: String,
                         subscribers: Int,
                         primary_language: String,
                         category: String,
                         country_name: String
                         )

class SubscriptionProfile(val profile: CustomPostgresProfile) {
  import profile.api._

  class MostSubscribed(tag: Tag) extends Table[MostSubscribedParams](tag, "most_subscribed_channels") {
    def index = column[Int]("index", O.PrimaryKey)
    def channels_name = column[String]("channel_names")
    def channel_line = column[String]("channel_line")
    def brand_status = column[String]("brand_status")
    def subscribers = column[Int]("subscribers")
    def primary_language = column[String]("primary_language")
    def category = column[String]("category")
    def country_name = column[String]("country_name")

    def * = (index, channels_name, channel_line, brand_status, subscribers, primary_language, category, country_name) <> (MostSubscribedParams.tupled, MostSubscribedParams.unapply)

    lazy val MostSubscribedTable = TableQuery[MostSubscribedParams]
  }
}

object MostSubscribedObject extends SubscriptionProfile(CustomPostgresProfile)
