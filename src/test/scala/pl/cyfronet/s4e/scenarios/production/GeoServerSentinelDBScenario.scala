package pl.cyfronet.s4e.scenarios.production

import java.text.SimpleDateFormat

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef.jdbcFeeder
import pl.cyfronet.s4e.Configuration
import pl.cyfronet.s4e.chunks.headers.GSHeaders

class GeoServerSentinelDBScenario {
  val format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
  val layerName = Configuration.LayerName
  val query = "SELECT p.layer_name,s.timestamp " +
    "FROM scene s LEFT JOIN product p ON s.product_id = p.id WHERE p.layer_name='" + layerName + "';";
  val feeder = jdbcFeeder("jdbc:postgresql://localhost:5433/sat4envi",
    "sat4envi", "sat4envi", query).circular.convert {
    case ("timestamp", value) => format.format(value)
  }

  private val scn = scenario("GeoServerSentinelDBScenario")
    .repeat(Configuration.RepeatScenario, "counterName") {
      feed(feeder)
        .exec(http("GS-${counterName}")
          .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&" +
            "LAYERS=development%3A" + layerName +
            "&TIME=${timestamp}&CRS=EPSG%3A3857&STYLES=&WIDTH=1454&HEIGHT=1358" +
            "&BBOX=261720.38484844333%2C5224623.757348367%2C3818182.436901124%2C8546271.258508986")
          .headers(GSHeaders.headers_7)
          .check(status.is(200))
          .check(bodyString.transform(_.size > 35000).is(true))
        )
    }

  def getScenario = scn
}
