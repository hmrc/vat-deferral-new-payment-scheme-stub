/*
 * Copyright 2020 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.vatdeferralnewpaymentschemestub.controllers

import play.api.mvc._
import uk.gov.hmrc.play.bootstrap.backend.controller.BackendController
import scala.io.Source.fromResource

abstract class BaseController(val cc: ControllerComponents) extends BackendController(cc) {

  def responseFromFile(filename: String) = {
    try {
      Ok(fromResource(filename).mkString)
    } catch {
      case _: NullPointerException => NotFound
    }
  }
}