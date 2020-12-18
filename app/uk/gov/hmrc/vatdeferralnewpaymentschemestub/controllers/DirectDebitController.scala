/*
 * Copyright 2020 HM Revenue & Customs
 *
 */

package uk.gov.hmrc.vatdeferralnewpaymentschemestub.controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc.{Action, AnyContent, ControllerComponents}
import uk.gov.hmrc.vatdeferralnewpaymentschemestub.config.AppConfig

@Singleton()
class DirectDebitController @Inject()(appConfig: AppConfig, cc: ControllerComponents)
    extends BaseController(cc) {

  def get(vrn: String): Action[AnyContent] = Action {
    responseFromFile(s"api-responses/direct-debit/vrn-$vrn.json")
  }
}
