package pl.cyfronet.s4e.scenarios.production

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import pl.cyfronet.s4e.chunks.headers.Headers

class GrdhCloseUps {
  private val grdhCloseUps = exec(http("GRDH-1")
    .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_grdh" +
      "&TIME=2020-02-25T16%3A26%3A25Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1691&HEIGHT=1358" +
      "&BBOX=59926.630175578175%2C5200163.90829711%2C4196087.1047430355%2C8521811.40945773")
    .headers(Headers.headers_0_close_ups))
    .exec(http("GRDH-2")
      .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_grdh" +
        "&TIME=2020-02-25T16%3A26%3A25Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1691&HEIGHT=1358" +
        "&BBOX=1147778.4167302065%2C5832451.00627209%2C3215858.6540139355%2C7493274.756852399")
      .headers(Headers.headers_0_close_ups))
    .exec(http("GRDH-3")
      .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_grdh" +
        "&TIME=2020-02-25T16%3A26%3A25Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1691&HEIGHT=1358" +
        "&BBOX=1690481.3175549582%2C6147983.059033296%2C2724521.4361968227%2C6978394.9343234515")
      .headers(Headers.headers_0_close_ups))
    .exec(http("GRDH-4")
      .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_grdh" +
        "&TIME=2020-02-25T16%3A26%3A25Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1691&HEIGHT=1358" +
        "&BBOX=1959386.783062208%2C6319507.750505232%2C2476406.84238314%2C6734713.68815031")
      .headers(Headers.headers_0_close_ups))
    .exec(http("GRDH-5")
      .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_grdh" +
        "&TIME=2020-02-25T16%3A26%3A25Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1691&HEIGHT=1358" +
        "&BBOX=2095368.2563815368%2C6406951.710863474%2C2353878.286042003%2C6614554.679686013")
      .headers(Headers.headers_0_close_ups))
    .exec(http("GRDH-6")
      .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_grdh" +
        "&TIME=2020-02-25T16%3A26%3A25Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1691&HEIGHT=1358" +
        "&BBOX=2154721.6088449764%2C6448304.143165754%2C2283976.623675209%2C6552105.627577024")
      .headers(Headers.headers_0_close_ups))
    .exec(http("GRDH-7")
      .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_grdh" +
        "&TIME=2020-02-25T16%3A26%3A25Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1691&HEIGHT=1358" +
        "&BBOX=2184360.066562553%2C6468942.140802751%2C2248987.5739776697%2C6520842.883008386")
      .headers(Headers.headers_0_close_ups))

  def getGrdhCloseUps = grdhCloseUps
}
