package pl.cyfronet.s4e

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import pl.cyfronet.s4e.scenarios.GeoServerScenario
import scala.concurrent.duration._

class GeoServerConstLoad extends Simulation {

  val httpProtocol = http
    .baseUrl(Configuration.BaseUrl)
    .inferHtmlResources()
    .acceptHeader("*/*")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-GB,en-US;q=0.9,en;q=0.8,pl;q=0.7")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/84.0.4147.135 Safari/537.36")

  val scenario = new GeoServerScenario().getScenario

//  setUp(scenario.inject(rampUsers(Configuration.UsersNumber) during (Configuration.UsersTimePeriod))).protocols(httpProtocol)
//    .throttle(reachRps(Configuration.ReachReps) in (Configuration.RepsInTime), holdFor(Configuration.RepsForTime minute))
  setUp(scenario.inject(rampUsers(Configuration.UsersNumber) during (Configuration.UsersTimePeriod))).protocols(httpProtocol)
    .throttle(reachRps(Configuration.ReachReps) in (Configuration.RepsInTime seconds), holdFor(Configuration.RepsForTime minutes))

}