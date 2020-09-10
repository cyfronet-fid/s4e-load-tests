package pl.cyfronet.s4e.scenarios

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import pl.cyfronet.s4e.Configuration
import pl.cyfronet.s4e.chunks.headers.GSHeaders

class GeoServerScenario {
  private val scn = scenario("GeoServerScenario")
    .repeat(Configuration.RepeatScenario){
      exec(http("GS-1")
        .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_slc&TIME=2020-01-14T04%3A26%3A18Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1454&HEIGHT=1358&BBOX=261720.38484844333%2C5224623.757348367%2C3818182.436901124%2C8546271.258508986")
        .headers(GSHeaders.headers_7)
        .resources(http("GS-2")
          .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_slc&TIME=2020-01-14T04%3A26%3A18Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1454&HEIGHT=1358&BBOX=261720.38484844333%2C5224623.757348367%2C3818182.436901124%2C8546271.258508986")
          .headers(GSHeaders.headers_7)))
        .exec(http("GS-3")
          .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_slc&TIME=2020-01-14T05%3A11%3A03Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1454&HEIGHT=1358&BBOX=261720.38484844333%2C5224623.757348367%2C3818182.436901124%2C8546271.258508986")
          .headers(GSHeaders.headers_7)
          .resources(http("GS-4")
            .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_slc&TIME=2020-01-14T16%3A21%3A38Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1454&HEIGHT=1358&BBOX=261720.38484844333%2C5224623.757348367%2C3818182.436901124%2C8546271.258508986")
            .headers(GSHeaders.headers_7)))
        .exec(http("GS-5")
          .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_slc&TIME=2020-01-08T04%3A25%3A37Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1454&HEIGHT=1358&BBOX=261720.38484844333%2C5224623.757348367%2C3818182.436901124%2C8546271.258508986")
          .headers(GSHeaders.headers_7)
          .resources(http("GS-6")
            .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_slc&TIME=2020-01-08T05%3A16%3A03Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1454&HEIGHT=1358&BBOX=261720.38484844333%2C5224623.757348367%2C3818182.436901124%2C8546271.258508986")
            .headers(GSHeaders.headers_7)))
        .exec(http("GS-7")
          .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_slc&TIME=2020-01-26T05%3A11%3A03Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1454&HEIGHT=1358&BBOX=261720.38484844333%2C5224623.757348367%2C3818182.436901124%2C8546271.258508986")
          .headers(GSHeaders.headers_7)
          .resources(http("GS-8")
            .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_slc&TIME=2020-01-26T16%3A21%3A38Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1454&HEIGHT=1358&BBOX=261720.38484844333%2C5224623.757348367%2C3818182.436901124%2C8546271.258508986")
            .headers(GSHeaders.headers_7)))
        .exec(http("GS-9")
          .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_slc&TIME=2020-01-26T05%3A11%3A03Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1454&HEIGHT=1358&BBOX=261720.38484844333%2C5224623.757348367%2C3818182.436901124%2C8546271.258508986")
          .headers(GSHeaders.headers_7)
          .resources(http("GS-10")
            .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_slc&TIME=2020-01-26T16%3A21%3A38Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1454&HEIGHT=1358&BBOX=261720.38484844333%2C5224623.757348367%2C3818182.436901124%2C8546271.258508986")
            .headers(GSHeaders.headers_7)))
    }

  def getScenario = scn
}
