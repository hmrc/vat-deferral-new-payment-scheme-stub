/*
 * Copyright 2020 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.vatdeferralnewpaymentschemestub.controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc.{Action, AnyContent, ControllerComponents}
import uk.gov.hmrc.play.bootstrap.backend.controller.BackendController
import uk.gov.hmrc.vatdeferralnewpaymentschemestub.config.AppConfig
import java.io.File

import scala.concurrent.Future

@Singleton()
class ObligationsController @Inject()(appConfig: AppConfig, cc: ControllerComponents)
    extends BackendController(cc) {

  def get(vrn: String): Action[AnyContent] = Action.async { implicit request =>

    val response = scala.io.Source.fromResource(s"app/uk/gov/hmrc/vatdeferralnewpaymentschemestub/resources/get-obligations/vrn-$vrn.json").mkString
    Future.successful(Ok(response))
  }
}
