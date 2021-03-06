package pl.cyfronet.s4e

import scala.concurrent.duration._

import com.typesafe.config.ConfigFactory

object Configuration {
  val conf = ConfigFactory.load()

  val BaseUrl = conf.getString("base.url")
  val WebBaseUrl = conf.getString("web.base.url")
  val GsBaseUrl = conf.getString("gs.base.url")
  val UsersNumber: Int = conf.getInt("users.number")
  val UsersTimePeriod: Int = conf.getInt("users.time.period")

  val RepeatScenario: Int = conf.getInt("repeat.scenario")
  val LayerName: String = conf.getString("layer.name")
  val s3Download: Boolean = conf.getBoolean("s3.force.download")

  val ReachReps: Int = conf.getInt("reps.reach")
  val RepsInTime: Int = conf.getInt("reps.in.time")
  val RepsForTime: Int = conf.getInt("reps.for.time")
}
