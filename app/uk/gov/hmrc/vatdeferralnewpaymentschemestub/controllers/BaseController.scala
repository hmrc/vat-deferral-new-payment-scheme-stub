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

  def acceptedResponseFromFile(filename: String) = {
    try {
      Accepted(fromResource(filename).mkString)
    } catch {
      case _: NullPointerException => NotFound
    }
  }
}