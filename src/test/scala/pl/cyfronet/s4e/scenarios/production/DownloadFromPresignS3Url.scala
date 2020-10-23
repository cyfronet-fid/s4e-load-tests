package pl.cyfronet.s4e.scenarios.production

import java.text.SimpleDateFormat

import pl.cyfronet.s4e.Configuration
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef.jdbcFeeder

class DownloadFromPresignS3Url {
  val query = "SELECT s.id FROM scene s;";
  val feeder = jdbcFeeder("jdbc:postgresql://localhost:5433/sat4envi",
    "sat4envi", "sat4envi", query).circular

  private val scn = scenario("DownloadFromPresignS3UrlScenario")
    .repeat(Configuration.RepeatScenario, "counterName") {
      feed(feeder)
        .exec(http("GS-${counterName}")
          .get("/api/v1/scenes/${id}/download")
            .disableFollowRedirect
          .header("Authorization", "Bearer eyJhbGciOiJSUzI1NiJ9.eyJzdWIiOiJhZG1pbkBtYWlsLnBsIiwiZXhwIjoxNjAzMzAyNzA2LCJhdXRob3JpdGllcyI6WyJST0xFX0FETUlOIl19.BchyMO3wPSKDCf9kHNq8SXaOtZS9pGSMy0ehfXww8N0lmYziI2tkEXQ1j-zVTiYSVp7BzcaALvZDKjZus3Q7urAjL-7WD6iJ2WNql5EM6AXpJCBBlpeTypRGf1uPMgK_5ZQpzDmeYs-qvbIXik_jwZLM24t8rnWsQHDa3Mra8_gudfRlP3FlOMo5x3jTuS2v1wCldvBJHUWi03hdRGoxjtUUaIK9IOPRkohkFLUNG6m9F4qzSMa2qSrRgFZORCwO6ljlnn027QZybI86AuwdVC2zYQ46lZELHzICDBqKRhjk4VH0XTFx4p9aRNLatWziYuwySpjJU4rbXTCjiDbiXg")
          .check(status.is(302))
          .check(header("Location").saveAs("url"))
        )
        .doIfOrElse(Configuration.s3Download){
          exec(http("GS-${counterName} - redirect")
            .get("${url}")
            .header("Content-Type", "application/force-download"))
        }{
          exec(http("GS-${counterName} - redirect")
            .get("${url}"))
        }
//        .exec( session => {
//          println(session( "url" ).as[String] )
//          session
//        })
    }

  def getScenario = scn
}
