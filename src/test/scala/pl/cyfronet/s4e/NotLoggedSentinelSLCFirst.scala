package pl.cyfronet.s4e

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import pl.cyfronet.s4e.scenarios.NotLoggedSentinelSLCFirstScenario

class NotLoggedSentinelSLCFirst extends Simulation {
  val httpProtocol = http
    .baseUrl(Configuration.BaseUrl)
    .inferHtmlResources()
    .acceptHeader("image/webp,image/apng,image/*,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-GB,en-US;q=0.9,en;q=0.8,pl;q=0.7")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.116 Safari/537.36")

  val scenario = new NotLoggedSentinelSLCFirstScenario().getScenario

  setUp(scenario.inject(rampUsers(Configuration.UsersNumber) during (Configuration.UsersTimePeriod))).protocols(httpProtocol)
}