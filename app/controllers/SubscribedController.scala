package controllers

import models.{MostSubscribedParams, SubscriptionProfile}

import javax.inject._
import play.api.mvc._
import slick.lifted.TableQuery

/**
 * Using the Kaggle dataset for the list of the most-subscribed YouTube channels in World,
 * this application will be one wherein you return the list of the most subscribed YouTube channels but also which YouTube channels you'll subscribe to based on certain likes
 */
@Singleton

class SubscribedController @Inject()(val controllerComponents: ControllerComponents) extends BaseController
  // do we need the below to sit within this class in order to perform queries?
  with TableQuery(new MostSubscribedParams(_)) {

  /**
   * Given the data set, what kind of operations do we want to do and return?
   *  - return basic information when you enter the channels_name or the channel_line?
   *  - return ordered list based on primary language
   *  - return ordered list based on category
    */


  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }
}
