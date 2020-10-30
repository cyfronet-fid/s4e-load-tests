package pl.cyfronet.s4e.scenarios.production

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import pl.cyfronet.s4e.chunks.headers.Headers

class SlcCloseUps {
  private val slcCloseUps = exec(http("SLC-1")
      .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_slc" +
        "&TIME=2020-02-03T04%3A59%3A27Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1691&HEIGHT=1358" +
        "&BBOX=1492968.0364660625%2C6810844.968322345%2C2527008.155107927%2C7641256.8436125005")
      .headers(Headers.headers_0_close_ups))
    .exec(http("SLC-2")
      .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_slc" +
        "&TIME=2020-02-03T04%3A59%3A27Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1691&HEIGHT=1358" +
        "&BBOX=1793671.3057399457%2C7026091.639973401%2C2310691.365060878%2C7441297.577618479")
      .headers(Headers.headers_0_close_ups))
    .exec(http("SLC-3")
      .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_slc" +
        "&TIME=2020-02-03T04%3A59%3A27Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1691&HEIGHT=1358" +
        "&BBOX=1944481.5625465987%2C7133409.227685789%2C2202991.592207065%2C7341012.1965083275")
      .headers(Headers.headers_0_close_ups))
    .exec(http("SLC-4")
      .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_slc" +
        "&TIME=2020-02-03T04%3A59%3A27Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1691&HEIGHT=1358" +
        "&BBOX=2017440.7060447994%2C7186838.710457127%2C2146695.7208750322%2C7290640.194868396")
      .headers(Headers.headers_0_close_ups))
    .exec(http("SLC-5")
      .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_slc" +
        "&TIME=2020-02-03T04%3A59%3A27Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1691&HEIGHT=1358&BBOX=2054722.8665908943%2C7214738.225781216%2C2119350.3740060106%2C7266638.967986851")
      .headers(Headers.headers_0_close_ups))

  def getSlcCloseUps = slcCloseUps
}
