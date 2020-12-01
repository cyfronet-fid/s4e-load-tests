package pl.cyfronet.s4e

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import pl.cyfronet.s4e.scenarios.production.{GrdhCloseUps, GrdmCloseUps, SlcCloseUps}
import scala.concurrent.duration._

class BaseCloseUps extends Simulation {
  val httpProtocol = http
    .baseUrl(Configuration.WebBaseUrl)
    .inferHtmlResources()
    .acceptHeader("image/avif,image/webp,image/apng,image/*,*/*;q=0.8")
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-GB,en-US;q=0.9,en;q=0.8,pl;q=0.7")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.111 Safari/537.36")

  val grdh = new GrdhCloseUps().getGrdhCloseUps
  val grdm = new GrdmCloseUps().getGrdmCloseUps
  val slc = new SlcCloseUps().getSlcCloseUps

  val scn = scenario("Sentinels Close Ups").exec(grdh, grdm).exec(grdm, slc).exec(slc, grdh)
//  val scn2 = scenario("Sentinels Close Ups 2").repeat(10) {
//    exec(slc, grdh).exec(grdh, grdm).exec(grdm, slc)
//  }

//  setUp(scn.inject(atOnceUsers(5)), scn2.inject(atOnceUsers(5))).protocols(httpProtocol)
    setUp(scn.inject(rampUsers(Configuration.UsersNumber) during Configuration.UsersTimePeriod)).protocols(httpProtocol)
      .throttle(reachRps(Configuration.ReachReps) in (Configuration.RepsInTime seconds), holdFor(Configuration.RepsForTime minutes))
}
