package pl.cyfronet.s4e

import com.typesafe.config.ConfigFactory

object Configuration {
  val conf = ConfigFactory.load()

  val BaseUrl = conf.getString("base.url")
  val UsersNumber: Int = conf.getString("users.number").toInt
  val UsersTimePeriod: Int = conf.getString("users.time.period").toInt
}
