package controllers

import play.api.mvc.{AnyContent, BaseController, ControllerComponents, Request}

import javax.inject.{Inject, Singleton}

/*
  This is where the rerouting will be done -> the reason for the splitting of the SubscribedController and this is so that we can split the testing for rerouting
 */
@Singleton
class HomeController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  /**
   * Given the data set, what kind of operations do we want to do and return?
   *  - return ordered list based on primary language
   *  - return ordered list based on category
   *  - return basic information when you enter the channels_name or the channel_line?
   */

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }
}