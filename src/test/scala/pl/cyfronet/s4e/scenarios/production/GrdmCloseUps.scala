package pl.cyfronet.s4e.scenarios.production

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import pl.cyfronet.s4e.chunks.headers.Headers

class GrdmCloseUps {
  private val grdmCloseUps = exec(http("GRDM-1")
      .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_grdm" +
        "&TIME=2020-02-27T04%3A58%3A58Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1691&HEIGHT=1358" +
        "&BBOX=189563.83014723728%2C6249491.43259601%2C4325724.304714695%2C9571138.933756629")
      .headers(Headers.headers_0_close_ups))
    .exec(http("GRDM-2")
      .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_grdm" +
        "&TIME=2020-02-27T04%3A58%3A58Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1691&HEIGHT=1358" +
        "&BBOX=1265185.6921762372%2C6816959.930585159%2C3333265.9294599663%2C8477783.681165468")
      .headers(Headers.headers_0_close_ups))
    .exec(http("GRDM-3")
      .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_grdm" +
        "&TIME=2020-02-27T04%3A58%3A58Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1691&HEIGHT=1358" +
        "&BBOX=1807888.5930009885%2C7116593.08146305%2C2841928.711642853%2C7947004.9567532055")
      .headers(Headers.headers_0_close_ups))
    .exec(http("GRDM-4")
      .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_grdm" +
        "&TIME=2020-02-27T04%3A58%3A58Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1691&HEIGHT=1358" +
        "&BBOX=2082603.2726579122%2C7266715.405015136%2C2599623.3319788445%2C7681921.342660214")
      .headers(Headers.headers_0_close_ups))
    .exec(http("GRDM-5")
      .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_grdm" +
        "&TIME=2020-02-27T04%3A58%3A58Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1691&HEIGHT=1358" +
        "&BBOX=2289174.341598601%2C7385422.109942014%2C2418429.3564288337%2C7489223.594353284")
      .headers(Headers.headers_0_close_ups))
    .exec(http("GRDM-6")
      .get("/wms?SERVICE=WMS&VERSION=1.3.0&REQUEST=GetMap&FORMAT=image%2Fpng&TRANSPARENT=true&LAYERS=development%3Asentinel_1_grdm" +
        "&TIME=2020-02-27T04%3A58%3A58Z&CRS=EPSG%3A3857&STYLES=&WIDTH=1691&HEIGHT=1358" +
        "&BBOX=2324086.9542678553%2C7405754.359465872%2C2388714.461682972%2C7457655.101671507")
      .headers(Headers.headers_0_close_ups))

  def getGrdmCloseUps = grdmCloseUps
}
