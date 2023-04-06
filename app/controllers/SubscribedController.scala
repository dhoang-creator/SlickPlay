package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import slick.jdbc.H2Profile.api._
import slick.jdbc.PostgresProfile.api._

import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import models.{MostSubscribed, MostSubscribedObject}

/**
 * Using the Kaggle dataset for the list of the most-subscribed YouTube channels in World,
 * this application will be one wherein you return the list of the most subscribed YouTube channels but also which YouTube channels you'll subscribe to based on certain likes
 */
@Singleton
class SubscribedController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  /**
   * Given the data set, what kind of operations do we want to do and return?
   *  - return ordered list based on primary language
   *  - return ordered list based on category
   *  - return basic information when you enter the channels_name or the channel_line?
    */

  object Connection {
    val db = Database.forConfig("postgres")
    val InMemDb = Database.forConfig("h2mem1")

    // we're having issues with the naming conventions of not only the fields within the tables but also what objects go in where, see below
    val primaryLanguage: Future[Seq[MostSubscribed]] = db.run(MostSubscribedObject.MostSubscribedTable.result)

    def findListByLanguage(primary_language: String): Future[Option[MostSubscribed]] = {
      db.run(MostSubscribedObject.MostSubscribedTable.filter(_.primary_language === primary_language).result.headOption)
    }
  }



//  try {
//    val resultFuture: Future[MostSubscribed] = // should this be the DBIO interaction for the models table
//    Await.result(resultFuture, Duration.Inf)
//    println(resultFuture)
//  } finally db.close

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }
}
