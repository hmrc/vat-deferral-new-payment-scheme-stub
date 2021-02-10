/*
 * Copyright 2021 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.vatdeferralnewpaymentschemestub.controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc.{Action, AnyContent, ControllerComponents}
import uk.gov.hmrc.vatdeferralnewpaymentschemestub.config.AppConfig

@Singleton()
class DirectDebitController @Inject()(appConfig: AppConfig, cc: ControllerComponents)
    extends BaseController(cc) {

  def get(vrn: String): Action[AnyContent] = Action {
    vrn match {
      case "9999999999" => NotFound // 404
      case "9999999998" => Unauthorized // 400
      case "9999999997" => InternalServerError // 500
      case "9999999996" => ServiceUnavailable // 503
      case _ =>
        responseFromFile(s"api-responses/direct-debit/vrn-$vrn.json")
    }
  }
}
