package controllers

import org.scalatest.funspec.AnyFunSpec
import play.api.mvc.request.RequestAttrKey.Server
import play.api.test.WsTestClient

import scala.concurrent.Await
import scala.concurrent.duration.DurationInt

class ExternalAPICall extends AnyFunSpec {

  // we need to break down the public endpoint of the below test
  describe ("External API gets the correct response from our public endpoint") {
    it ("get all repositories") {

      Server.withRouterFromComponents() { cs = > {
        case GET(p"/Application") => cs.defaultActionBuilder {
          Results.Ok(Json.arr(Json.obj("")))
        }
      }
      } { implicit port =>
        WsTestClient.withClient { client =>
          val result = Await.result(
            new ExternalAPICall(client, "").repositories(), 10.seconds)
          result must_==Seq("")
        }
      }
    }
  }

}
