package computerdatabase

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class Sample extends Simulation {  // Simulationクラスを拡張してSampleクラスを作成

  val httpProtocol = http  // 共通のhttp設定
    .baseUrl("https://localhost:3000/")  // ベースURLを設定
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
    .doNotTrackHeader("1")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .acceptEncodingHeader("gzip, deflate")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val scn = scenario("Sample Scenario")  // シナリオを定義
    .exec(http("request_1").get("/"))

  setUp(scn.inject(constantConcurrentUsers(5) during (10))).protocols(httpProtocol)  // シナリオシミュレーションの設定
}
