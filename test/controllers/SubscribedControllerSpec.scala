package controllers

import org.scalatest.GivenWhenThen
import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.must.Matchers

/**
 * Given the data set, what kind of operations do we want to do and return?
 *  - return basic information when you enter the channels_name or the channel_line?
 *  - return ordered list based on primary language
 *  - return ordered list based on category
 */

class SubscribedControllerSpec extends AnyFunSpec with Matchers with GivenWhenThen {

  describe("User inputs channels name or channel line") {
    it("valid channel name found") {

      When("the user inputs a valid channel name")

      Then("application triggers query of the DB")
    }
    it("invalid user input") {

      When("user inputs data that is not within the scope to be searched")

      Then("an exception should be thrown")
    }
    it("valid user input but not found") {

      When("user inputs valid data")

      And("valid data does not match in DB")

      Then("exception should be thrown")
    }
  }

  describe("User inputs primary language") {
    it("primary language found") {

      When("the user inputs a valid language based on ISO")

      Then("application triggers query of the DB")

      And("returns ordered list based on the primary language")
    }
    it("invalid user input") {

      When("user inputs data that is not within the scope to be searched")

      Then("an exception should be thrown")
    }
    it("valid user input but not found") {

      When("user inputs valid data")

      And("valid data does not match in DB")

      Then("exception should be thrown")
    }
  }

  describe("User inputs category") {
    it("category found") {

      When("the user inputs a valid category")

      Then("application triggers query of the DB")

      And("returns ordered list based on the category")
    }
    it("invalid user input") {

      When("user inputs data that is not within the scope to be searched")

      Then("an exception should be thrown")
    }
    it("valid user input but not found") {

      When("user inputs valid data")

      And("valid data does not match in DB")

      Then("exception should be thrown")
    }
  }

}