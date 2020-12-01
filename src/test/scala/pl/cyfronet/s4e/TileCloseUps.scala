package pl.cyfronet.s4e

import scala.concurrent.duration._
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._
import pl.cyfronet.s4e.scenarios.production.GrdhTileCloseUps

class TileCloseUps extends Simulation {

	val httpProtocol = http
		.baseUrl(Configuration.WebBaseUrl)
		.inferHtmlResources()
		.acceptHeader("image/avif,image/webp,image/apng,image/*,*/*;q=0.8")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-GB,en-US;q=0.9,en;q=0.8,pl;q=0.7")
		.userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 11_0_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.198 Safari/537.36")

	val grdh = new GrdhTileCloseUps().getGrdhTileCloseUps

	val scn = scenario("Sentinels Close Ups").exec(grdh)

	setUp(scn.inject(rampUsers(Configuration.UsersNumber) during Configuration.UsersTimePeriod)).protocols(httpProtocol)
}